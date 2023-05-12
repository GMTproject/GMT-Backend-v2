package com.pmn.gmt.domain.teacher.domain.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "teacher")
@NoArgsConstructor
@AllArgsConstructor
public class Teacher {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "name",nullable = false,length = 100)
    private String name;

    @Column(name = "contact",nullable = false,length = 100)
    private String contact;

    @Column(name = "department",length = 100)
    private String department;

    @Column(name = "location", nullable = false, length = 100)
    private String location;

    @Column(name = "position", nullable = false, length = 100)
    private String position;

    @Column(name = "subject", length = 100)
    private String subject;

    @Column(name = "free_club", length = 100)
    private String free;

    @Column(name = "major_club", length = 100)
    private String major;

    @Column(name = "skill_club", length = 100)
    private String skill;

    @Column(name = "afterschool_class", length = 100)
    private String classes;
}
