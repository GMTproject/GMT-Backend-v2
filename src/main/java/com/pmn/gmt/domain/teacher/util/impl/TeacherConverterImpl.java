package com.pmn.gmt.domain.teacher.util.impl;

import com.pmn.gmt.domain.teacher.domain.dto.FilterDto;
import com.pmn.gmt.domain.teacher.domain.dto.TeacherDto;
import com.pmn.gmt.domain.teacher.domain.dto.requestDto.FilterRequestDto;
import com.pmn.gmt.domain.teacher.domain.dto.responseDto.TeacherResponseDto;
import com.pmn.gmt.domain.teacher.domain.entity.Teacher;
import com.pmn.gmt.domain.teacher.util.TeacherConverter;
import org.springframework.stereotype.Component;

@Component
public class TeacherConverterImpl implements TeacherConverter {

    @Override
    public TeacherDto toDto(Teacher teacher) {
        return new TeacherDto(
                teacher.getName(),
                teacher.getContact(),
                teacher.getDepartment(),
                teacher.getLocation(),
                teacher.getPosition(),
                teacher.getSubject(),
                teacher.getFree(),
                teacher.getMajor(),
                teacher.getSkill()
              //  ,teacher.getClasses()
        );
    }

    @Override
    public TeacherResponseDto toResponseDto(TeacherDto teacherDto) {
        return new TeacherResponseDto(
                teacherDto.getName(),
                teacherDto.getContact(),
                teacherDto.getDepartment(),
                teacherDto.getLocation(),
                teacherDto.getPosition(),
                teacherDto.getSubject(),
                teacherDto.getFree(),
                teacherDto.getMajor(),
                teacherDto.getSkill()
              //  ,teacherDto.getClasses()
        );
    }

    @Override
    public FilterDto toDto(FilterRequestDto filterRequestDto) {
        return new FilterDto(
                filterRequestDto.isFree(),
                filterRequestDto.isMajor(),
                filterRequestDto.isSkill(),
                filterRequestDto.isGrade1(),
                filterRequestDto.isGrade2(),
                filterRequestDto.isGrade3()
        );
    }
}
