package com.pmn.gmt.domain.auth.service.impl;

import com.pmn.gmt.domain.auth.presentation.data.dto.RefreshTokenDto;

public interface GetNewRefreshTokenService {
    RefreshTokenDto execute(RefreshTokenDto refreshTokenDto);
}
