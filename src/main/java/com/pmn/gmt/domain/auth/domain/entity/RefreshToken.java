package com.pmn.gmt.domain.auth.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@RedisHash(value = "refreshToken", timeToLive = 60L * 60 * 24 * 7)
@Getter
public class RefreshToken {

    @Id
    private int id;

    private String token;

    private int userId;

    public RefreshToken(int userId, String token) {
        this.userId = userId;
        this.token = token;
    }
}
