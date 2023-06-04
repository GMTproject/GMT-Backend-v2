package com.pmn.gmt.domain.teacher.service.impl;

import com.pmn.gmt.domain.teacher.controller.data.dto.TeacherDto;
import com.pmn.gmt.domain.teacher.domain.repository.TeacherRepository;
import com.pmn.gmt.domain.teacher.service.FindAllTeacherService;
import com.pmn.gmt.domain.teacher.util.TeacherConverter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FindAllTeacherServiceImpl implements FindAllTeacherService{
    TeacherRepository teacherRepository;
    TeacherConverter teacherConverter;

    public FindAllTeacherServiceImpl(TeacherRepository teacherRepository, TeacherConverter teacherConverter) {
        this.teacherRepository = teacherRepository;
        this.teacherConverter = teacherConverter;
    }

    @Override
    public List<TeacherDto> execute() {
        return teacherRepository.findAll().stream()
                .map(it -> teacherConverter.toDto(it))
                .collect(Collectors.toList());
    }
}
