package com.pmn.gmt.domain.auth.service;

import com.pmn.gmt.domain.auth.presentation.data.dto.RefreshTokenDto;

public interface GetNewRefreshTokenService {
    RefreshTokenDto execute(RefreshTokenDto refreshTokenDto);
}
