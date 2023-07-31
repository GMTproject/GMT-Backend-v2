package com.pmn.gmt.domain.auth.service;

import com.pmn.gmt.domain.auth.presentation.data.dto.RefreshTokenDto;
import com.pmn.gmt.domain.auth.presentation.data.responseDto.RefreshTokenResponseDto;

public interface GetNewRefreshTokenService {
    RefreshTokenResponseDto execute(RefreshTokenDto refreshTokenDto);
}
