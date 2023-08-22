package com.pmn.gmt.domain.teacher.service.impl;

import com.pmn.gmt.domain.teacher.domain.entity.Teacher;
import com.pmn.gmt.domain.teacher.domain.repository.TeacherRepository;
import com.pmn.gmt.domain.teacher.presentation.data.dto.NameDto;
import com.pmn.gmt.domain.teacher.presentation.data.dto.TeacherDto;
import com.pmn.gmt.domain.teacher.service.FindTeachersByNameService;
import com.pmn.gmt.domain.teacher.util.TeacherConverter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FindTeachersByNameServiceImpl implements FindTeachersByNameService {
    TeacherRepository teacherRepository;
    TeacherConverter teacherConverter;

    public FindTeachersByNameServiceImpl(TeacherRepository teacherRepository, TeacherConverter teacherConverter){
        this.teacherRepository = teacherRepository;
        this.teacherConverter = teacherConverter;
    }


    @Override
    public List<TeacherDto> execute(NameDto nameDto) {
        List<Teacher> nameFilter = teacherRepository.findByNameContaining(nameDto.name); // DTO 값 보기
        return nameFilter.stream()
                .map(it -> teacherConverter.toDto(it))
                .collect(Collectors.toList());
    }

}
