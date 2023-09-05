package com.pmn.gmt.domain.map.service.impl;

import com.pmn.gmt.domain.map.domain.repository.MapRepository;
import com.pmn.gmt.domain.map.presentation.data.dto.ClassDto;
import com.pmn.gmt.domain.map.presentation.data.dto.ClassNameDto;
import com.pmn.gmt.domain.map.service.FindClassByNameService;
import com.pmn.gmt.domain.map.util.MapConverter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FindClassByNameServiceImpl implements FindClassByNameService {

    private final MapRepository mapRepository;
    private final MapConverter mapConverter;

    @Override
    public List<ClassDto> execute(ClassNameDto classNameDto) {
        return mapRepository.findByNameContaining(classNameDto.getClassName()).stream()
                .map(mapConverter::toDto)
                .collect(Collectors.toList());
    }
}
