package com.pmn.gmt.domain.teacher.domain.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "teachers", schema = "gmt")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "contact", nullable = false, length = 100)
    private String contact;

    @Column(name = "department", length = 100)
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

//    @Column(name = "afterschool_class", length = 100)
//    private String classes;

    @Builder
    public Teacher(String name, String contact, String department,
                   String location, String position,
                   String subject, String free, String major,
                   String skill ) { //, String classes
        this.name = name;
        this.contact = contact;
        this.department = department;
        this.location = location;
        this.position = position;
        this.subject = subject;
        this.free = free;
        this.major = major;
        this.skill = skill;
//        this.classes = classes;
    }
}