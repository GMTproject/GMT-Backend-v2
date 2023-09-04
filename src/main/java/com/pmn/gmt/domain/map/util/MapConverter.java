package com.pmn.gmt.domain.map.util;

import com.pmn.gmt.domain.map.domain.entity.Map;
import com.pmn.gmt.domain.map.presentation.data.dto.ClassDto;
import com.pmn.gmt.domain.map.presentation.data.dto.DetailClassDto;
import com.pmn.gmt.domain.map.presentation.data.dto.ClassNameDto;
import com.pmn.gmt.domain.map.presentation.data.dto.TeacherDto;
import com.pmn.gmt.domain.map.presentation.data.responseDto.DetailClassResponseDto;
import com.pmn.gmt.domain.map.presentation.data.responseDto.TeacherResponseDto;
import com.pmn.gmt.domain.teacher.domain.entity.Teacher;

public interface MapConverter {
    ClassNameDto toDto(String className);
    TeacherDto toDto(Teacher teacher);
    ClassDto toDto(Map map);
    DetailClassDto toDetailDto(Map map);
    TeacherResponseDto toResponseDto(TeacherDto teacherDto);
    DetailClassResponseDto toResponseDto(DetailClassDto detailClassDto);
}

