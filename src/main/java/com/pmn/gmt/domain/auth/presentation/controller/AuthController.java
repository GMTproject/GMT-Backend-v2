package com.pmn.gmt.domain.auth.presentation.controller;

import com.pmn.gmt.domain.auth.presentation.data.responseDto.LoginResponseDto;
import com.pmn.gmt.domain.auth.presentation.data.responseDto.LoginUrlResponseDto;
import com.pmn.gmt.domain.auth.presentation.data.responseDto.RefreshTokenResponseDto;
import com.pmn.gmt.domain.auth.service.GetNewRefreshTokenService;
import com.pmn.gmt.domain.auth.service.LoginService;
import com.pmn.gmt.domain.auth.service.LoginUrlService;
import com.pmn.gmt.domain.auth.service.LogoutService;
import com.pmn.gmt.domain.auth.util.AuthConverter;
import com.pmn.gmt.domain.auth.util.AuthUtil;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
@CrossOrigin(origins = {"https://gmt-pmn.shop", "https://gmt-pmn.store"})
public class AuthController {

    private LoginService loginService;
    private LogoutService logoutService;
    private LoginUrlService loginUrlService;
    private GetNewRefreshTokenService getNewRefreshTokenService;
    private AuthConverter authConvertor;

    AuthUtil authUtil;

    @GetMapping
    public ResponseEntity<LoginUrlResponseDto> loginUrl(){
        return ResponseEntity.ok(loginUrlService.execute());
    }

    @GetMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestParam(value = "code") String code) {
        authUtil.authLog("get 매핑 컨트롤러 /login");
        return ResponseEntity.ok(loginService.execute(authConvertor.toDto(code)));
    }

    @GetMapping("/logout")
    public ResponseEntity<Void> logout(){
        logoutService.execute();
        return ResponseEntity.noContent().build();
    }

    @PatchMapping
    public ResponseEntity<RefreshTokenResponseDto> getNewRefreshToken(@RequestHeader("Refresh-Token") String refreshToken, @RequestBody(required = false) String deviceToken){
        return ResponseEntity.ok(getNewRefreshTokenService.execute(authConvertor.toDto(refreshToken, deviceToken)));
    }

}
