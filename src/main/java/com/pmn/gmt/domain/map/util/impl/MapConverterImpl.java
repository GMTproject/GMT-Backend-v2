package com.pmn.gmt.domain.map.util.impl;

import com.pmn.gmt.domain.map.domain.entity.Map;
import com.pmn.gmt.domain.map.presentation.data.dto.DetailClassDto;
import com.pmn.gmt.domain.map.presentation.data.dto.ClassNameDto;
import com.pmn.gmt.domain.map.presentation.data.dto.TeacherDto;
import com.pmn.gmt.domain.map.presentation.data.responseDto.DetailClassResponseDto;
import com.pmn.gmt.domain.map.presentation.data.responseDto.TeacherResponseDto;
import com.pmn.gmt.domain.map.util.MapConverter;
import com.pmn.gmt.domain.teacher.domain.entity.Teacher;
import org.springframework.stereotype.Component;

@Component
public class MapConverterImpl implements MapConverter {
    @Override
    public ClassNameDto toDto(String className) {
        return new ClassNameDto(
                className
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
    public DetailClassDto toDto(Map map) {
        return new DetailClassDto(
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
    public DetailClassResponseDto toResponseDto(DetailClassDto detailClassDto) {
        return new DetailClassResponseDto(
                detailClassDto.getFloor(),
                detailClassDto.getLocation(),
                detailClassDto.getExplains()
        );
    }
}
