package com.csc.cardinal.park;

import jakarta.persistence.*;
import lombok.Getter;


@Getter

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

    @Column
    private String operator;

    public ParkEntity() {

    }
    public ParkEntity(String name, String description, double length, String address, String county ) {
        this.name = name;
        this.description = description;
        this.rating_Total = 0.0;
        this.rating_Count = 0;
        this.length = length;
        this.address = address;
        this.county = county;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRating_Total(double rating_Total) {
        if (this.rating_Total == 0.0 || this.rating_Count == 0) {
            this.rating_Total = rating_Total;
        }else{
            this.rating_Total = ((this.rating_Total * this.rating_Count) + rating_Total) / this.rating_Count + 1;
        }
        setRating_Count(this.rating_Count + 1);
    }

    public void setRating_Count(int rating_Count) {
        this.rating_Count = rating_Count;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }
}

