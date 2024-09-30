package com.g1.appdev.francis_and_friends.student;

import com.g1.appdev.francis_and_friends.project.ProjectEntity;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name="studentDb")
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer studentID;

    @Column(nullable = false)
    private String studentFirstName;

    @Column(nullable = false)
    private String studentLastName;

    @Column(nullable = false, unique = true)
    private String email;

    public StudentEntity(){
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

    @OneToMany(mappedBy = "student")
    private List<ProjectEntity> courses; // Changed to List<ProjectEntity>
}
