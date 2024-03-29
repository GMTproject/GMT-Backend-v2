package com.pmn.gmt.domain.map.service.impl;

import com.pmn.gmt.domain.map.domain.repository.MapRepository;
import com.pmn.gmt.domain.map.exception.ClassRoomNotFoundException;
import com.pmn.gmt.domain.map.presentation.data.dto.DetailClassDto;
import com.pmn.gmt.domain.map.presentation.data.dto.ClassNameDto;
import com.pmn.gmt.domain.map.service.FindDetailClassByNameService;
import com.pmn.gmt.domain.map.util.MapConverter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FindDetailClassByNameServiceImpl implements FindDetailClassByNameService {

    private final MapRepository mapRepository;
    private final MapConverter mapConverter;

    @Override
    public DetailClassDto execute(ClassNameDto classNameDto) {
        if(mapRepository.findByName(classNameDto.getClassName()).isEmpty())
            throw new ClassRoomNotFoundException();
        else{
            return mapConverter.toDetailDto(mapRepository.findByName(classNameDto.getClassName()).get(0));
        }
    }
}
