package com.csc.cardinal.user;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@Entity
@Table(name = "hikes")
public class GroupHikeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String usersFullName;

    @Column
    private  String description;

    @Column
    private String trailName;

    @Column
    private String county;

    @Column
    private String hikeTime;

    @ManyToMany
    @JoinTable(
            name = "hike_participants",
            joinColumns = @JoinColumn(name = "hike_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<UserEntity> participants;

    public GroupHikeEntity() {

    }

    public GroupHikeEntity(String usersFullName, String trailName, String county, String hikeTime, String description) {
        this.usersFullName = usersFullName;
        this.trailName = trailName;
        this.county = county;
        this.hikeTime = hikeTime;
        this.description = description;
    }

    public void addParticipant(UserEntity user) {
        participants.add(user);
    }
}
