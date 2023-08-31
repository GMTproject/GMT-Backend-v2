package com.pmn.gmt.domain.map.domain.entity;


import com.pmn.gmt.domain.map.domain.entity.location.Structure;
import com.pmn.gmt.domain.teacher.domain.entity.Teacher;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "map", schema = "gmt")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Map {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name="teacher_id")
    private Teacher teacher;

    private int floor;

    @Enumerated(EnumType.STRING)
    private Structure location;

    private String explains;

}
