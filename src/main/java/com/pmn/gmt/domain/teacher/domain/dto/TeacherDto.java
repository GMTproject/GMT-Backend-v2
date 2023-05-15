package com.pmn.gmt.domain.teacher.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TeacherDto {
    private String name;
    private String contact;
    private String department;
    private String location;
    private String position;
    private String subject;
    private String free;
    private String major;
    private String skill;
    private String classes;
}
