package com.pmn.gmt.Component;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component

public class ConnectComponent {
    @Value(" ${SPRING_REDIS_HOST}")
    private Integer spring_redis_host;


}
