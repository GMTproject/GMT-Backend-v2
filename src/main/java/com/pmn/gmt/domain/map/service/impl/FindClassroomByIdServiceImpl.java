package com.pmn.gmt.domain.map.service.impl;

import com.pmn.gmt.domain.map.domain.repository.MapRepository;
import com.pmn.gmt.domain.map.exception.ClassRoomNotFoundException;
import com.pmn.gmt.domain.map.presentation.data.dto.MapDto;
import com.pmn.gmt.domain.map.presentation.data.dto.ClassNameDto;
import com.pmn.gmt.domain.map.service.FindClassroomByIdService;
import com.pmn.gmt.domain.map.util.MapConverter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FindClassroomByIdServiceImpl implements FindClassroomByIdService {

    private final MapRepository mapRepository;
    private final MapConverter mapConverter;

    @Override
    public MapDto execute(ClassNameDto mapIdDto) {
        if(mapRepository.findById(mapIdDto.getMapId()).isPresent()){
            return mapConverter.toDto(mapRepository.findById(mapIdDto.getMapId()).get());
        }else
            throw new ClassRoomNotFoundException();
    }
}
