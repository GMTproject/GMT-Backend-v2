package com.pmn.gmt.domain.teacher.presentation.data.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class FilterDto {
    private boolean free;
    private boolean major;
    private boolean skill;
    private boolean grade1;
    private boolean grade2;
    private boolean grade3;
    private String name;
}
