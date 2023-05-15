package com.pmn.gmt.domain.teacher.service;

import com.pmn.gmt.domain.teacher.domain.dto.TeacherDto;

public interface FindTeacherByIdService {
    TeacherDto execute(int id);
}
