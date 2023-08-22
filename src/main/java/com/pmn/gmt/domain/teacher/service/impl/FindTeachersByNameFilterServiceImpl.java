package com.pmn.gmt.domain.teacher.service.impl;

import com.pmn.gmt.domain.teacher.domain.entity.Teacher;
import com.pmn.gmt.domain.teacher.domain.repository.TeacherRepository;
import com.pmn.gmt.domain.teacher.presentation.data.dto.NameDto;
import com.pmn.gmt.domain.teacher.presentation.data.dto.TeacherDto;
import com.pmn.gmt.domain.teacher.service.FindTeachersByNameFilterService;
import com.pmn.gmt.domain.teacher.util.TeacherConverter;
import org.springframework.stereotype.Service;

import javax.naming.Name;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class FindTeachersByNameFilterServiceImpl implements FindTeachersByNameFilterService {
    TeacherRepository teacherRepository;
    TeacherConverter teacherConverter;

    public FindTeachersByNameFilterServiceImpl(TeacherRepository teacherRepository, TeacherConverter teacherConverter){
        this.teacherRepository = teacherRepository;
        this.teacherConverter = teacherConverter;
    }


    @Override
    public List<TeacherDto> execute(NameDto nameDto) {
        List<Teacher> nameFilter = new ArrayList<>(teacherRepository.findByNameContaining(nameDto.name)); // DTO 값 보기
        return nameFilter.stream()
                .map(it -> teacherConverter.toDto(it))
                .collect(Collectors.toList());
    }

}
