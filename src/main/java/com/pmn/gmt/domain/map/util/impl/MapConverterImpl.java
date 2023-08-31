package com.pmn.gmt.domain.map.util.impl;

import com.pmn.gmt.domain.map.domain.entity.Map;
import com.pmn.gmt.domain.map.presentation.data.dto.MapDto;
import com.pmn.gmt.domain.map.presentation.data.dto.MapIdDto;
import com.pmn.gmt.domain.map.presentation.data.dto.TeacherDto;
import com.pmn.gmt.domain.map.presentation.data.responseDto.MapResponseDto;
import com.pmn.gmt.domain.map.util.MapConverter;
import com.pmn.gmt.domain.teacher.domain.entity.Teacher;
import com.pmn.gmt.domain.teacher.presentation.data.responseDto.TeacherResponseDto;
import org.springframework.stereotype.Component;

@Component
public class MapConverterImpl implements MapConverter {
    @Override
    public MapIdDto toDto(int mapId) {
        return new MapIdDto(
                mapId
        );
    }

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
        );
    }

    @Override
    public MapDto toDto(Map map) {
        return new MapDto(
                map.getFloor(),
                map.getLocation().getDescription(),
                map.getExplains()
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
        );
    }

    @Override
    public MapResponseDto toResponseDto(MapDto mapDto) {
        return new MapResponseDto(
                mapDto.getFloor(),
                mapDto.getLocation(),
                mapDto.getExplains()
        );
    }
}
