package com.pmn.gmt.domain.auth.service;

import com.pmn.gmt.domain.auth.presentation.data.responseDto.LoginUrlResponseDto;
import com.pmn.gmt.global.gauth.util.GAuthProperties;

public interface LoginUrlService {
    LoginUrlResponseDto execute();
}
