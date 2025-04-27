package com.bassoumi.demo;


import jakarta.persistence.*;

@Entity
@Table(name ="t_student")
public class student {
    @Id
    @GeneratedValue()
    private Integer id ;
    @Column (
            name = "c-fname" ,
            length = 20
    )
    private String FirstName;
    private String LastName;

    @Column(unique = true)
    private String Email;
    private Integer age;

    @Column(updatable = false)
    private String some_colum;

    public student() {
    }

    public student(String firstName, String lastName, String email, Integer age) {
        FirstName = firstName;
        LastName = lastName;
        Email = email;
        this.age = age;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
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
