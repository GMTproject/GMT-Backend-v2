package com.pmn.gmt.domain.map.presentation.data.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MapDto {
    private int floor;
    private String location;
    private String explains;
}