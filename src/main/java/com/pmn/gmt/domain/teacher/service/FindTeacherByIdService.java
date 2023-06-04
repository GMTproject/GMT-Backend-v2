package com.pmn.gmt.domain.teacher.service;

import com.pmn.gmt.domain.teacher.controller.data.dto.TeacherDto;

public interface FindTeacherByIdService {
    TeacherDto execute(int id);
}
