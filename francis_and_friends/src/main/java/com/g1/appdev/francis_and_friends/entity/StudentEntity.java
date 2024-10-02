package com.g1.appdev.francis_and_friends.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="studentDb")
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "studentID")
    private Integer studentID;

    @Column(name = "studentFirstName")
    private String studentFirstName;

    @Column(name = "studentLastName")
    private String studentLastName;

    @Column(name = "studentEmail")
    private String email;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<ProjectEntity> courses;


    public StudentEntity() {
        super();
    }


    public StudentEntity(Integer studentID, String studentFirstName, String studentLastName, String email) {
        this.studentID = studentID;
        this.studentFirstName = studentFirstName;
        this.studentLastName = studentLastName;
        this.email = email;
    }


    public Integer getStudentID() {
        return studentID;
    }

    public void setStudentID(Integer studentID) {
        this.studentID = studentID;
    }

    public String getStudentFirstName() {
        return studentFirstName;
    }

    public void setStudentFirstName(String studentFirstName) {
        this.studentFirstName = studentFirstName;
    }

    public String getStudentLastName() {
        return studentLastName;
    }

    public void setStudentLastName(String studentLastName) {
        this.studentLastName = studentLastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public List<ProjectEntity> getCourses() {
        return courses;
    }

    public void setCourses(List<ProjectEntity> courses) {
        this.courses = courses;
    }
}
