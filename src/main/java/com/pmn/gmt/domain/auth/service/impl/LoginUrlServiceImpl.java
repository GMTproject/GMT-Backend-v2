package com.pmn.gmt.domain.auth.service.impl;

import com.pmn.gmt.domain.auth.presentation.data.responseDto.LoginUrlResponseDto;
import com.pmn.gmt.domain.auth.service.LoginUrlService;
import com.pmn.gmt.global.gauth.util.GAuthProperties;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LoginUrlServiceImpl implements LoginUrlService {

    GAuthProperties gAuthProperties;

    @Override
    public LoginUrlResponseDto execute() {
        return new LoginUrlResponseDto(
                "https://gauth.co.kr/login?client_id="+gAuthProperties.getClientId()+"&redirect_uri="+gAuthProperties.getRedirectUri()
        );
    }
}
