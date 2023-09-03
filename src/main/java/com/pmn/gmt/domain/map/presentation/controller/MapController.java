package com.pmn.gmt.domain.map.presentation.controller;

import com.pmn.gmt.domain.map.presentation.data.responseDto.MapResponseDto;
import com.pmn.gmt.domain.map.presentation.data.responseDto.TeacherResponseDto;
import com.pmn.gmt.domain.map.service.FindClassroomByIdService;
import com.pmn.gmt.domain.map.service.FindTeachersByMapIdService;
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

    private final FindTeachersByMapIdService findTeachersByMapId;

    private final FindClassroomByIdService findClassroomByIdService;
    private final MapConverter mapConverter;

    @GetMapping("/{map_id}")
    ResponseEntity<MapResponseDto> findClassroomById(@PathVariable("map_id") int mapId){
        return ResponseEntity.ok(mapConverter.toResponseDto(findClassroomByIdService.execute(mapConverter.toDto(mapId))));
    }

    @GetMapping("/{map_id}/teachers")
    ResponseEntity<List<TeacherResponseDto>> findTeachersByMapId(@PathVariable("map_id") int mapId){
        return ResponseEntity.ok((findTeachersByMapId.execute(mapConverter.toDto(mapId))).stream()
                .map(mapConverter::toResponseDto)
                .collect(Collectors.toList()));
    }
}