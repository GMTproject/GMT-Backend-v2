package com.pmn.gmt.domain.teacher.controller;

import com.pmn.gmt.domain.teacher.domain.dto.responseDto.TeacherResponseDto;
import com.pmn.gmt.domain.teacher.service.FindAllTeacherService;
import com.pmn.gmt.domain.teacher.util.TeacherConverter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/teacher")
public class TeacherController {

    private final FindAllTeacherService findAllTeacherService;
    private final TeacherConverter teacherConverter;

    public TeacherController(FindAllTeacherService findAllTeacherService, TeacherConverter teacherConverter) {
        this.findAllTeacherService = findAllTeacherService;
        this.teacherConverter = teacherConverter;
    }
    @GetMapping
    public ResponseEntity<List<TeacherResponseDto>> findAllTeacher() {
        return ResponseEntity.ok(findAllTeacherService.execute().stream()
                .map(teacherConverter::toResponseDto)
                .collect(Collectors.toList()));
    }



}
