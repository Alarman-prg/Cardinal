package com.csc.cardinal.user;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
//    @ColumnDefault(value = "user")
    private String username;

    @Column
//    @ColumnDefault(value = "jegreene1@uncg.edu")
    private String email;

    @Column
//    @ColumnDefault(value = "password")
    private String password;

    @Column
//    @ColumnDefault(value = "Jacob")
    private String firstName;

    @Column
//    @ColumnDefault(value = "Greene")
    private String lastName;



    public UserEntity() {

    }
    public UserEntity(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }
}
