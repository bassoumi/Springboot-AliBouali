package com.bassoumi.demo;

import jakarta.persistence.*;

@Entity
@Table(name = "t_student")
public class student {  // you want lowercase, keeping it like this
    @Id
    @GeneratedValue()
    private Integer id;

    private String firstname;
    private String lastname;

    @Column(unique=true)
    private String email;
    private Integer age;

    // Default constructor
    public student() {
    }

    // Constructor with fields
    public student(String firstname, String lastname, String email, Integer age) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.age = age;
    }

    // Getters and Setters
    public String getFirstname() {
        return firstname;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
