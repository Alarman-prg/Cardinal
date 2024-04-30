package com.csc.cardinal.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@Entity
@Table(name = "hike_participants")
public class HikeParticipantsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "hike_id")
    private GroupHikeEntity hike;

    @ManyToOne
    @JoinColumn(name = "usernme")
    private UserEntity user;

    public HikeParticipantsEntity(GroupHikeEntity hike, UserEntity user) {
        this.hike = hike;
        this.user = user;
    }

    public HikeParticipantsEntity() {

    }
}
