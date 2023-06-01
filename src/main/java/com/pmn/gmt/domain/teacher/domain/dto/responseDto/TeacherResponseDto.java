package com.pmn.gmt.domain.teacher.domain.dto.responseDto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class TeacherResponseDto {
    private String name;
    private String contact;
    private String department;
    private String location;
    private String position;
    private String subject;
    private String free;
    private String major;
    private String skill;
   // private String classes;
}
