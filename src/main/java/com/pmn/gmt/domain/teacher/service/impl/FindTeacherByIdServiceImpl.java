package com.pmn.gmt.domain.teacher.service.impl;

import com.pmn.gmt.domain.teacher.controller.data.dto.TeacherDto;
import com.pmn.gmt.domain.teacher.domain.repository.TeacherRepository;
import com.pmn.gmt.domain.teacher.service.FindTeacherByIdService;
import com.pmn.gmt.domain.teacher.util.TeacherConverter;
import org.springframework.stereotype.Service;

@Service
public class FindTeacherByIdServiceImpl implements FindTeacherByIdService {

    TeacherRepository teacherRepository;
    TeacherConverter teacherConverter;

    public FindTeacherByIdServiceImpl(TeacherRepository teacherRepository, TeacherConverter teacherConverter) {
        this.teacherRepository = teacherRepository;
        this.teacherConverter = teacherConverter;
    }

    @Override
    public TeacherDto execute(int id) {
        return teacherConverter.toDto(teacherRepository.findById(id).get());
    }
}
