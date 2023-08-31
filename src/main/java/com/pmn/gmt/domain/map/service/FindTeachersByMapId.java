package com.pmn.gmt.domain.map.service;

import com.pmn.gmt.domain.map.presentation.data.dto.MapIdDto;
import com.pmn.gmt.domain.map.presentation.data.dto.TeacherDto;

import java.util.List;

public interface FindTeachersByMapId {
    List<TeacherDto> execute(MapIdDto mapIdDto);
}
