package com.csc.cardinal.park;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "parks")
public class ParkEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private double rating_Total;            //Should ratings include descriptions this will need to be moved to its own table

    @Column
    private int rating_Count;               //This as well for above comment

    @Column
    private double length;

    @Column
    private String address;

    @Column
    private String county;



    public ParkEntity() {

    }
    public ParkEntity(String name, String description, double length, String address, String county ) {
        this.name = name;
        this.description = description;
        this.rating_Total = 0.0;
        this.length = length;
        this.address = address;
        this.county = county;
    }
}

