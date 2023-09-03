package com.pmn.gmt.domain.map.service;

import com.pmn.gmt.domain.map.presentation.data.dto.MapDto;
import com.pmn.gmt.domain.map.presentation.data.dto.ClassNameDto;

public interface FindClassByNameService {
    MapDto execute(ClassNameDto classNameDto);
}
