package com.pmn.gmt.domain.teacher.controller;

import com.pmn.gmt.domain.teacher.domain.dto.responseDto.TeacherResponseDto;
import com.pmn.gmt.domain.teacher.service.FindAllTeacherService;
import com.pmn.gmt.domain.teacher.util.TeacherConverter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;


@RestController
public class TeacherController {

    private final FindAllTeacherService findAllTeacherService;
    private final TeacherConverter teacherConverter;

    public TeacherController(FindAllTeacherService findAllTeacherService, TeacherConverter teacherConverter) {
        this.findAllTeacherService = findAllTeacherService;
        this.teacherConverter = teacherConverter;
    }
    @GetMapping("teacher/filter")
    public List<TeacherResponseDto> findAllTeacher() {
        return findAllTeacherService.execute().stream()
                .map(teacherConverter::toResponseDto)
                .collect(Collectors.toList());
    }



}
