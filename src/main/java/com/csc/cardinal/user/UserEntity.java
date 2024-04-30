package com.csc.cardinal.user;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/***
 * @Author Jacob
 * @Author Christian
 */
@Getter
@Setter
@Entity(name = "userEntity")
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String username;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private String firstName;

    @Column
    private String lastName;



    public UserEntity() {

    }
    public UserEntity(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public static class getUsername extends UserEntity {
    }
}
