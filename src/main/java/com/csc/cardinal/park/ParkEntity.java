package com.csc.cardinal.park;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "parks")
public class ParkEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    @Setter(AccessLevel.NONE)
    private double rating_Total;            //Should ratings include descriptions this will need to be moved to its own table

    @Column
    private int rating_Count;               //This as well for above comment

    @Column
    private double length;

    @Column
    private String address;

    @Column
    private String county;

    @Column
    private String operator;

    public ParkEntity() {

    }
    public ParkEntity(String name, String description, double length, String address, String county, String operator) {
        this.name = name;
        this.description = description;
        this.rating_Total = 0.0;
        this.rating_Count = 0;
        this.length = 2.0;
        this.address = address;
        this.county = county;
        this.operator = operator;
    }
    public void setRating_Total(double rating_Total) {
        if (this.rating_Total == 0.0 || this.rating_Count == 0) {
            this.rating_Total = rating_Total;
        }else{
            this.rating_Total = ((this.rating_Total * this.rating_Count) + rating_Total) / this.rating_Count + 1;
        }
        setRating_Count(this.rating_Count + 1);
    }

}

