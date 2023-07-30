package com.pmn.gmt.domain.auth.presentation.data.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.lang.Nullable;

@Getter
@AllArgsConstructor
public class RefreshTokenDto {
    @Nullable
    private String deviceToken;
    private String refreshToken;
}
