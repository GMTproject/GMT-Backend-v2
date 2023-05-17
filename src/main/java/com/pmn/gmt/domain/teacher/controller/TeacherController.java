package com.pmn.gmt.domain.teacher.controller;

import com.pmn.gmt.domain.teacher.domain.dto.TeacherDto;
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

    @GetMapping("/teachers")
    public List<TeacherResponseDto> execute() {
        List<TeacherDto> teacherDtos = findAllTeacherService.execute();

        return teacherDtos.stream()
                .map(teacherConverter::toResponseDto)
                .collect(Collectors.toList());
    }

}
