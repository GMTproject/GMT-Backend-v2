package com.pmn.gmt.global.security.jwt;

import com.pmn.gmt.domain.auth.exception.InvalidTokenException;
import com.pmn.gmt.domain.user.domain.entity.role.UserRole;
import com.pmn.gmt.global.security.auth.AuthDetailsService;
import com.pmn.gmt.domain.user.exception.RoleNotExistException;
import com.pmn.gmt.domain.auth.exception.ExpiredTokenException;
import com.pmn.gmt.global.security.jwt.properties.JwtProperties;
import com.pmn.gmt.global.security.jwt.properties.TokenTimeProperties;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.security.Key;
import java.time.ZonedDateTime;
import java.util.*;
@Component
public class JwtTokenProvider {
    private final JwtProperties jwtProperties;
    private final TokenTimeProperties tokenTimeProperties;
    private final AuthDetailsService authDetailsService;

    private static final String ACCESS_TYPE = "access";
    private static final String REFRESH_TYPE = "refresh";
    private static final String TOKEN_PREFIX = "Bearer ";
    private static final String AUTHORITY = "authority";

    public JwtTokenProvider(JwtProperties jwtProperties, TokenTimeProperties tokenTimeProperties, AuthDetailsService authDetailsService) {
        this.jwtProperties = jwtProperties;
        this.tokenTimeProperties = tokenTimeProperties;
        this.authDetailsService = authDetailsService;
    }

    public ZonedDateTime getAccessExpiredTime() {
        return ZonedDateTime.now().plusSeconds(tokenTimeProperties.getAccessTime());
    }

    public ZonedDateTime getRefreshExpiredTime() {
        return ZonedDateTime.now().plusSeconds(tokenTimeProperties.getRefreshTime());
    }

    public String generateAccessToken(String email, UserRole role) {
        return generateToken(email, ACCESS_TYPE, jwtProperties.getAccessSecret(), tokenTimeProperties.getAccessTime(), role);
    }

    public String generateRefreshToken(String email, UserRole role) {
        return generateToken(email, REFRESH_TYPE, jwtProperties.getRefreshSecret(), tokenTimeProperties.getRefreshTime(), role);
    }

    public String resolveToken(HttpServletRequest req) {
        String token = req.getHeader("Authorization");
        return token != null ? parseToken(token) : null;
    }

    public String extractEmailFromRefreshToken(String refresh) {
        return getTokenSubject(refresh, jwtProperties.getRefreshSecret());
    }

    public UserRole extractRoleFromRefreshToken(String refresh) {
        String authority = getTokenBody(refresh, jwtProperties.getRefreshSecret()).get(AUTHORITY, String.class);
        switch (authority) {
            case "STUDENT":
                return UserRole.STUDENT;
            case "TEACHER":
                return UserRole.TEACHER;
            default:
                throw new RoleNotExistException();
        }
    }

    public String extractTypeFromRefreshToken(String refresh) {
        return getTokenSubject(refresh, jwtProperties.getRefreshSecret());
    }

    public Authentication authenticate(String token) {
        String email = getTokenSubject(token, jwtProperties.getAccessSecret());
        UserDetails userDetails = authDetailsService.loadUserByUsername(email);
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

    public String parseToken(String token) {
        return token.startsWith(TOKEN_PREFIX) ? token.replace(TOKEN_PREFIX, "") : null;
    }

    private String generateToken(String email, String type, Key secret, long exp, UserRole role) {
        Claims claims = Jwts.claims().setSubject(email);
        claims.put("type", type);
        claims.put(AUTHORITY, role);

        return Jwts.builder()
                .setHeaderParam("typ", "JWT")
                .signWith(secret, SignatureAlgorithm.HS256)
                .setClaims(claims)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + exp * 1000))
                .compact();
    }

    private Claims getTokenBody(String token, Key secret) {
        try {
            return Jwts.parserBuilder()
                    .setSigningKey(secret)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
        } catch (ExpiredJwtException e) {
            throw new ExpiredTokenException();
        } catch (Exception e) {
            throw new InvalidTokenException();
        }
    }

    private String getTokenSubject(String token, Key secret) {
        return getTokenBody(token, secret).getSubject();
    }
}
