package com.g1.appdev.francis_and_friends.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "projectDb")
public class ProjectEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "projectID")
    private Integer projectID;

    @Column(name = "projectTitle", nullable = false)
    private String title;

    @Column(name = "projectDescription", nullable = false)
    private String description;

    @Column(name = "projectStatus", nullable = false)
    private String status;

    @Column(name = "projectDeadline", nullable = false)
    private String deadline;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private StudentEntity student;


    public ProjectEntity() {

    }

    public ProjectEntity(String deadline, String status, String description, String title) {
        this.deadline = deadline;
        this.status = status;
        this.description = description;
        this.title = title;
    }

    // Getters and Setters
    public Integer getProjectID() {
        return projectID;
    }

    public void setProjectID(Integer projectID) {
        this.projectID = projectID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public StudentEntity getStudent() {
        return student;
    }

    public void setStudent(StudentEntity student) {
        this.student = student;
    }
}
