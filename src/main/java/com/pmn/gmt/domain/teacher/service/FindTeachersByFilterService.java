package com.pmn.gmt.domain.teacher.service;

import com.pmn.gmt.domain.teacher.controller.data.dto.FilterDto;
import com.pmn.gmt.domain.teacher.controller.data.dto.TeacherDto;

import java.util.List;

public interface FindTeachersByFilterService {
    List<TeacherDto> execute(FilterDto filterDto);
}
