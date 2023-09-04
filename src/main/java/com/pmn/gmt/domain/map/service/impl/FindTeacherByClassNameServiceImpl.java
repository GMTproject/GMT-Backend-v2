package com.pmn.gmt.domain.map.service.impl;

import com.pmn.gmt.domain.map.domain.entity.Map;
import com.pmn.gmt.domain.map.domain.repository.MapRepository;
import com.pmn.gmt.domain.map.exception.ClassRoomNotFoundException;
import com.pmn.gmt.domain.map.presentation.data.dto.ClassNameDto;
import com.pmn.gmt.domain.map.presentation.data.dto.TeacherDto;
import com.pmn.gmt.domain.map.service.FindTeachersByClassNameService;
import com.pmn.gmt.domain.map.util.MapConverter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FindTeacherByClassNameServiceImpl implements FindTeachersByClassNameService {

    private final MapRepository mapRepository;
    private final MapConverter mapConverter;

    @Override
    public List<TeacherDto> execute(ClassNameDto classNameDto) {
        List<Map> classroom = mapRepository.findByName(classNameDto.getClassName());

        if(classroom.isEmpty())
            throw new ClassRoomNotFoundException();
        else if(classroom.get(0).getTeacher() == null)
            return new ArrayList<>();
        else{
            return classroom.stream()
                    .map(it -> mapConverter.toDto(it.getTeacher()))
                    .collect(Collectors.toList());
        }
    }
}
