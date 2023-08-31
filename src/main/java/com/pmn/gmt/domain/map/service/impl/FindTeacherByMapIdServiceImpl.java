package com.pmn.gmt.domain.map.service.impl;

import com.pmn.gmt.domain.map.domain.repository.MapRepository;
import com.pmn.gmt.domain.map.exception.ClassRoomNotFoundException;
import com.pmn.gmt.domain.map.presentation.data.dto.MapIdDto;
import com.pmn.gmt.domain.map.presentation.data.dto.TeacherDto;
import com.pmn.gmt.domain.map.service.FindTeachersByMapIdService;
import com.pmn.gmt.domain.map.util.MapConverter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FindTeacherByMapIdServiceImpl implements FindTeachersByMapIdService {

    private final MapRepository mapRepository;
    private final MapConverter mapConverter;

    @Override
    public List<TeacherDto> execute(MapIdDto mapIdDto) {
        if(mapRepository.findById(mapIdDto.getMapId()).isPresent()){
            return mapRepository.findById(mapIdDto.getMapId()).get()
                    .getTeacher().stream()
                    .map(mapConverter::toDto)
                    .collect(Collectors.toList());
        }else
            throw new ClassRoomNotFoundException();
    }
}
