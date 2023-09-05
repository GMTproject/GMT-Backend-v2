package com.pmn.gmt.domain.map.service;

import com.pmn.gmt.domain.map.presentation.data.dto.DetailClassDto;
import com.pmn.gmt.domain.map.presentation.data.dto.ClassNameDto;
public interface FindDetailClassByNameService {
    DetailClassDto execute(ClassNameDto classNameDto);
}
