package com.mn.model;


public class User
{
    private int id;
    private String firstName;
    private String username;
    private String email;

    public User() {
    }

    public User(int id, String firstName, String username, String email) {
        this.id = id;
        this.firstName = firstName;
        this.username = username;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}