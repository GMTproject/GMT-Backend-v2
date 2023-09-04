package com.pmn.gmt.domain.map.service;

import com.pmn.gmt.domain.map.presentation.data.dto.ClassDto;
import com.pmn.gmt.domain.map.presentation.data.dto.ClassNameDto;

import java.util.List;

public interface FindClassByNameService {
    List<ClassDto> execute(ClassNameDto classNameDto);
}
