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
        Set<Teacher> filterSet = new HashSet<>(teacherRepository.findAll());
        if(filterDto.isFree())
            filterSet = filtering(filterSet, teacherRepository.findByFreeIsNotNull());
        if(filterDto.isMajor())
            filterSet = filtering(filterSet, teacherRepository.findByMajorIsNotNull());
        if(filterDto.isSkill())
            filterSet = filtering(filterSet, teacherRepository.findBySkillIsNotNull());
        if(filterDto.isGrade1())
            filterSet = filtering(filterSet, teacherRepository.findByPositionContaining("1-"));
        if(filterDto.isGrade2())
            filterSet = filtering(filterSet, teacherRepository.findByPositionContaining("2-"));
        if(filterDto.isGrade3())
            filterSet = filtering(filterSet, teacherRepository.findByPositionContaining("3-"));

        return new ArrayList<>(filterSet).stream()
                .map(it -> teacherConverter.toDto(it))
                .collect(Collectors.toList());
    }

    Set<Teacher> filtering(Set<Teacher> teacherList, List<Teacher> filterList) {
        Set<Teacher> resultList = new HashSet<>();
        teacherList.forEach(it -> {
            if (filterList.contains(it)) {
                resultList.add(it);
            }
        });
        return resultList;
    }
}
