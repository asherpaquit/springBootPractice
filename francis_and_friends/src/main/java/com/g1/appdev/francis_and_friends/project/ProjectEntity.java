package com.g1.appdev.francis_and_friends.project;

import com.g1.appdev.francis_and_friends.student.StudentEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "projectDb")
public class ProjectEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer projectID;
    @Column(nullable = false)
    private String Title;
    @Column(nullable = false)
    private String Description;
    @Column(nullable = false)
    private String Status;
    @Column(nullable = false)
    private String deadline;

    public ProjectEntity(String deadline, String status, String description, String title, Integer projectID) {
        this.deadline = deadline;
        Status = status;
        Description = description;
        Title = title;
        this.projectID = projectID;
    }

    public Integer getProjectID() {
        return projectID;
    }

    public void setProjectID(Integer projectID) {
        this.projectID = projectID;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    @ManyToOne
    @JoinColumn(name = "id")
    private StudentEntity student;
}
