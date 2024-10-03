package com.example.demo.dto;


public class UserDto {
    private String username;
    private String firstname;
    private String lastname;
    private String email;
    private String university;
    private Long id;

    public UserDto(String username, String firstname, String lastname, String email, Long id, String university) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.id = id;
        this.university = university;
    }

    public String getUsername(){
        return username;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
