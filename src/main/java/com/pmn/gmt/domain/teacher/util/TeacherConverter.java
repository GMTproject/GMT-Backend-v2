package com.pmn.gmt.domain.teacher.util;

import com.pmn.gmt.domain.teacher.domain.dto.FilterDto;
import com.pmn.gmt.domain.teacher.domain.dto.TeacherDto;
import com.pmn.gmt.domain.teacher.domain.dto.requestDto.FilterRequestDto;
import com.pmn.gmt.domain.teacher.domain.dto.responseDto.TeacherResponseDto;
import com.pmn.gmt.domain.teacher.domain.entity.Teacher;

public interface TeacherConverter {
    TeacherDto toDto(Teacher teacher);
    Teacher toEntity(TeacherDto teacherDto);
    TeacherResponseDto toResponseDto(TeacherDto teacherDto);
    FilterDto toDto(FilterRequestDto filterRequestDto);

}
