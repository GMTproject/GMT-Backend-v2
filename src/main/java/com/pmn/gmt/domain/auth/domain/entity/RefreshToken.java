package com.pmn.gmt.domain.auth.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@NoArgsConstructor
@AllArgsConstructor
@RedisHash(value = "refreshToken", timeToLive = 60L * 60 * 24 * 7)
@Getter
public class RefreshToken {

    @Id
    private int userId;

    private String token;
}
