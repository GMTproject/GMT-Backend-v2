package com.pmn.gmt.domain.map.presentation.data.responseDto;

import com.pmn.gmt.domain.map.domain.entity.location.Structure;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ClassResponseDto {
    private String name;
    private int floor;
    private Structure location;
}
