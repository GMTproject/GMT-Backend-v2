package com.pmn.gmt.domain.map.util;

import com.pmn.gmt.domain.map.presentation.data.dto.MapIdDto;
import com.pmn.gmt.domain.map.presentation.data.dto.TeacherDto;
import com.pmn.gmt.domain.teacher.domain.entity.Teacher;
import com.pmn.gmt.domain.teacher.presentation.data.responseDto.TeacherResponseDto;

public interface MapConverter {
    MapIdDto toDto(int mapId);
    TeacherDto toDto(Teacher teacher);
    TeacherResponseDto toResponseDto(TeacherDto teacherDto);
}

