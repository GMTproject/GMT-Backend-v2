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


    @Override
    public String toString() {
        return "[Name: " + name +
                ", Contact: " + contact +
                ", Department: " + department +
                ", Location: " + location +
                ", Position: " + position +
                ", Subject: " + subject +
                ", Free Club: " + free +
                ", Major Club: " + major +
                ", Skill Club: " + skill +
                "]";
    }
}
