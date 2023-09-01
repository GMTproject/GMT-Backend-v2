package com.pmn.gmt.domain.map.util;

import com.pmn.gmt.domain.map.domain.entity.Map;
import com.pmn.gmt.domain.map.presentation.data.dto.MapDto;
import com.pmn.gmt.domain.map.presentation.data.dto.MapIdDto;
import com.pmn.gmt.domain.map.presentation.data.dto.TeacherDto;
import com.pmn.gmt.domain.map.presentation.data.responseDto.MapResponseDto;
import com.pmn.gmt.domain.map.presentation.data.responseDto.TeacherResponseDto;
import com.pmn.gmt.domain.teacher.domain.entity.Teacher;

public interface MapConverter {
    MapIdDto toDto(int mapId);
    TeacherDto toDto(Teacher teacher);
    MapDto toDto(Map map);
    TeacherResponseDto toResponseDto(TeacherDto teacherDto);
    MapResponseDto toResponseDto(MapDto mapDto);
}

