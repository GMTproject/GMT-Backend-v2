package com.pmn.gmt.domain.map.domain.entity;


import com.pmn.gmt.domain.map.domain.entity.location.Structure;
import com.pmn.gmt.domain.teacher.domain.entity.Teacher;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "map", schema = "gmt")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
public class Map {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "map_id")
    private int id;

    @Column(name = "class")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    private int floor;

    @Enumerated(EnumType.STRING)
    private Structure location;

    private String explains;

}
