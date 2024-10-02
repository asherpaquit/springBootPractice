package com.g1.appdev.francis_and_friends.dto;

public class ProjectDetailsDTO {
    private Integer projectID;
    private String title;
    private String description;
    private String status;
    private String deadline;

    // Constructor, Getters and Setters
    public ProjectDetailsDTO(Integer projectID, String title, String description, String status, String deadline) {
        this.projectID = projectID;
        this.title = title;
        this.description = description;
        this.status = status;
        this.deadline = deadline;
    }

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
}
