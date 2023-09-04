package com.pmn.gmt.domain.map.presentation.controller;

import com.pmn.gmt.domain.map.presentation.data.responseDto.DetailClassResponseDto;
import com.pmn.gmt.domain.map.presentation.data.responseDto.TeacherResponseDto;
import com.pmn.gmt.domain.map.service.FindDetailClassByNameService;
import com.pmn.gmt.domain.map.service.FindTeachersByClassNameService;
import com.pmn.gmt.domain.map.util.MapConverter;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/map")
@AllArgsConstructor
public class MapController {

    private final FindTeachersByClassNameService findTeachersByClassNameService;

    private final FindDetailClassByNameService findDetailClassByNameService;
    private final MapConverter mapConverter;

    @GetMapping("/{class_name}")
    ResponseEntity<DetailClassResponseDto> findDetailClassByName(@PathVariable("class_name") String className){
        return ResponseEntity.ok(mapConverter.toResponseDto(findDetailClassByNameService.execute(mapConverter.toDto(className))));
    }

    @GetMapping("/{class_name}/teachers")
    ResponseEntity<List<TeacherResponseDto>> findTeachersByClassName(@PathVariable("class_name") String className){
        return ResponseEntity.ok((findTeachersByClassNameService.execute(mapConverter.toDto(className))).stream()
                .map(mapConverter::toResponseDto)
                .collect(Collectors.toList()));
    }
}
