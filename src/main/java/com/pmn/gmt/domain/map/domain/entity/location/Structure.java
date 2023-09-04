package com.pmn.gmt.domain.map.domain.entity.location;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Structure {
    MAIN("본관"), ANNEX("금봉관"), DORMITORY("기숙사");

    private final String description;
}
