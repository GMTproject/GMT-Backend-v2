package com.pmn.gmt.domain.teacher.service.impl;

import com.pmn.gmt.domain.teacher.domain.dto.FilterDto;
import com.pmn.gmt.domain.teacher.domain.dto.TeacherDto;
import com.pmn.gmt.domain.teacher.domain.entity.Teacher;
import com.pmn.gmt.domain.teacher.domain.repository.TeacherRepository;
import com.pmn.gmt.domain.teacher.service.FindTeachersByFilterService;
import com.pmn.gmt.domain.teacher.util.TeacherConverter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class FindTeachersByFilterServiceImpl implements FindTeachersByFilterService {

    TeacherRepository teacherRepository;
    TeacherConverter teacherConverter;

    public FindTeachersByFilterServiceImpl(TeacherRepository teacherRepository, TeacherConverter teacherConverter) {
        this.teacherRepository = teacherRepository;
        this.teacherConverter = teacherConverter;
    }

    @Override
    public List<TeacherDto> execute(FilterDto filterDto) {
        Set<Teacher> set = new HashSet<>();
        if(filterDto.isFree())
            set.addAll(teacherRepository.findByFreeIsNotNull());
        if(filterDto.isMajor())
            set.addAll(teacherRepository.findByMajorIsNotNull());
        if(filterDto.isSkill())
            set.addAll(teacherRepository.findBySkillIsNotNull());
        if(filterDto.isGrade1())
            set.addAll(teacherRepository.findByPositionContaining("1학년"));
        if(filterDto.isGrade2())
            set.addAll(teacherRepository.findByPositionContaining("2학년"));
        if(filterDto.isGrade3())
            set.addAll(teacherRepository.findByPositionContaining("3학년"));

        return new ArrayList<>(set).stream()
                .map(it -> teacherConverter.toDto(it))
                .collect(Collectors.toList());
    }
}
