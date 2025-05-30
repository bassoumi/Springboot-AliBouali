package com.bassoumi.demo.studentProfile;


import com.bassoumi.demo.student.student;
import jakarta.persistence.*;

@Entity
public class StudentProfile {


    @Id
    @GeneratedValue
    private Integer id;
    private String bio;

    @OneToOne
    @JoinColumn(
            name = "student_id"
    )

    private student student;
    public StudentProfile() {
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public StudentProfile(String bio, Integer id) {
        this.bio = bio;
        this.id = id;
    }


}
