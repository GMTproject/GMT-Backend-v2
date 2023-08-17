package com.pmn.gmt.domain.auth.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

@NoArgsConstructor
@AllArgsConstructor
@RedisHash(value = "refreshToken", timeToLive = 60L * 60 * 24 * 7)
@Getter
public class RefreshToken {

    @Indexed
    private int userId;

    @Id
    @Indexed
    private String token;
}
