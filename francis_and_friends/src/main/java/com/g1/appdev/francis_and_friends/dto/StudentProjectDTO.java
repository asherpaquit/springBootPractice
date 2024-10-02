package com.g1.appdev.francis_and_friends.dto;

import java.util.List;

public class StudentProjectDTO {
    private Integer studentID;
    private String studentFirstName;
    private String studentLastName;
    private String email;
    private List<ProjectDetailsDTO> projects;


    public StudentProjectDTO(Integer studentID, String studentFirstName, String studentLastName, String email, List<ProjectDetailsDTO> projects) {
        this.studentID = studentID;
        this.studentFirstName = studentFirstName;
        this.studentLastName = studentLastName;
        this.email = email;
        this.projects = projects;
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

    public List<ProjectDetailsDTO> getProjects() {
        return projects;
    }

    public void setProjects(List<ProjectDetailsDTO> projects) {
        this.projects = projects;
    }
}
