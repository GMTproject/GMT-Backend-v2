package com.pmn.gmt.domain.teacher.service;

import com.pmn.gmt.domain.teacher.domain.dto.FilterDto;
import com.pmn.gmt.domain.teacher.domain.dto.TeacherDto;

import java.util.List;

public interface FindTeachersByFilter {
    List<TeacherDto> execute(FilterDto filterDto);
}
