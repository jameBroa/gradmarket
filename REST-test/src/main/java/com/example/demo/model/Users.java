package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String university;

    public Users(String username, String firstname, String lastname, String email, String university) {
        this.username = username;
        this.firstName = firstname;
        this.lastName = lastname;
        this.email = email;
        this.university = university;
    }
    public Users() {

    }
    public Users orElse(Users users) {
        return users;
    }

    public String getUniversity() {
        return university;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }
}
