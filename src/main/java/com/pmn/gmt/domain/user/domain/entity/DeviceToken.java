package com.pmn.gmt.domain.user.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;


@Entity
@Getter
@DynamicUpdate
@NoArgsConstructor
@AllArgsConstructor
public class DeviceToken {

    @Id
    private int userId = 0;

    @MapsId
    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "user")
    private User user;


    @Column(length = 512)
    private String token;
}