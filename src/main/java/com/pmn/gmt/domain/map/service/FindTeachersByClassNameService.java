package com.pmn.gmt.domain.map.service;

import com.pmn.gmt.domain.map.presentation.data.dto.ClassNameDto;
import com.pmn.gmt.domain.map.presentation.data.dto.TeacherDto;

import java.util.List;

public interface FindTeachersByClassNameService {
    List<TeacherDto> execute(ClassNameDto classNameDto);
}
