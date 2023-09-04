package com.pmn.gmt.domain.map.service;

import com.pmn.gmt.domain.map.presentation.data.dto.DetailClassDto;
import com.pmn.gmt.domain.map.presentation.data.dto.ClassNameDto;

import java.util.List;

public interface FindDetailClassByNameService {
    List<DetailClassDto> execute(ClassNameDto classNameDto);
}
