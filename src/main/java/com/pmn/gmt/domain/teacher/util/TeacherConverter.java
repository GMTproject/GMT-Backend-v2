package com.pmn.gmt.domain.teacher.util;

import com.pmn.gmt.domain.teacher.controller.data.dto.FilterDto;
import com.pmn.gmt.domain.teacher.controller.data.dto.TeacherDto;
import com.pmn.gmt.domain.teacher.controller.data.requestDto.FilterRequestDto;
import com.pmn.gmt.domain.teacher.controller.data.responseDto.TeacherResponseDto;
import com.pmn.gmt.domain.teacher.domain.entity.Teacher;

public interface TeacherConverter {
    TeacherDto toDto(Teacher teacher);
    TeacherResponseDto toResponseDto(TeacherDto teacherDto);
    FilterDto toDto(FilterRequestDto filterRequestDto);

}
