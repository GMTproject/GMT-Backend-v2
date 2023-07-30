package com.pmn.gmt.domain.auth.presentation.data.reqeuestDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.lang.Nullable;

@Getter
@AllArgsConstructor
public class RefreshTokenRequestDto {
    @Nullable
    private String deviceToken;
    private String refreshToken;
}
