package com.pmn.gmt.global.security.jwt.properties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.stereotype.Component;

@Component
@Getter
@ConstructorBinding
public class TokenTimeProperties {
    Long accessTime;
    Long refreshTime;

    public TokenTimeProperties(@Value("${jwt.time.accessTime}") Long accessTime,
                               @Value("${jwt.time.refreshTime}")Long refreshTime) {
        this.accessTime = accessTime;
        this.refreshTime = refreshTime;
    }
}
