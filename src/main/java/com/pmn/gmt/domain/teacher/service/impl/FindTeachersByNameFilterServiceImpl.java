package com.pmn.gmt.domain.teacher.service.impl;

import com.pmn.gmt.domain.teacher.domain.entity.Teacher;
import com.pmn.gmt.domain.teacher.domain.repository.TeacherRepository;
import com.pmn.gmt.domain.teacher.presentation.data.dto.NameDto;
import com.pmn.gmt.domain.teacher.presentation.data.dto.TeacherDto;
import com.pmn.gmt.domain.teacher.service.FindTeachersByNameFilterService;
import com.pmn.gmt.domain.teacher.util.TeacherConverter;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        Set<Teacher> nameFilterSet = new HashSet<>(teacherRepository.findByNameContaining(nameKeyword)); // HASH 형태로 김,박,이 등등으로 조회
        if(nameDto.getName()){
            nameFilterSet =
        }


        return teacherConverter.toDto(teacherRepository.findByTeachersName());
    }
}
