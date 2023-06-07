package com.pmn.gmt.global.security.jwt.properties;

import io.jsonwebtoken.security.Keys;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.stereotype.Component;

import java.security.Key;

@Component
@Getter
@ConstructorBinding
public class JwtProperties {
    private final Key accessSecret;
    private final Key refreshSecret;

    public JwtProperties(@Value("${jwt.accessSecret}") String accessSecret,
                         @Value("${jwt.refreshSecret}") String refreshSecret) {
        this.accessSecret = Keys.hmacShaKeyFor(accessSecret.getBytes());
        this.refreshSecret = Keys.hmacShaKeyFor(refreshSecret.getBytes());
    }
}