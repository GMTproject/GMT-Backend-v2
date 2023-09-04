package com.pmn.gmt.domain.map.presentation.data.dto;

import com.pmn.gmt.domain.map.domain.entity.location.Structure;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DetailClassDto {
    private int floor;
    private Structure location;
    private String explains;
}
