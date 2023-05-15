package com.pmn.gmt.domain.teacher.service;

import com.pmn.gmt.domain.teacher.domain.dto.TeacherDto;

import java.util.List;

public interface FindAllTeacherService {
    List<TeacherDto> execute();
}
