package com.pmn.gmt.domain.map.presentation.data.responseDto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MapResponseDto {
    private int floor;
    private String location;
    private String explains;
}
