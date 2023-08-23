package com.pmn.gmt.domain.teacher.service;

import com.pmn.gmt.domain.teacher.presentation.data.dto.NameDto;
import com.pmn.gmt.domain.teacher.presentation.data.dto.TeacherDto;

import java.util.List;

public interface FindTeachersByNameService {
    List<TeacherDto> execute(NameDto nameDto);
}
