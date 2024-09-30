package com.g1.appdev.francis_and_friends.project;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ProjectDetailsRepository {
    private List<ProjectEntity> proDe= new ArrayList<>();

    Optional<ProjectDetails> findById(Integer projectId){
        return proDe.stream()
                .filter(run -> run.projectId() == projectId)
                .findFirst();
    }

    List<ProjectDetails> findAll(){
        return proDe;
    }

    void create(ProjectDetails proDes){
        proDe.add(proDes);
    }

    void update(ProjectDetails proDes, Integer projectId){
        Optional<ProjectDetails> existingProDe = findById(projectId);
        if(existingProDe.isPresent()){
            proDe.set(proDe.indexOf(existingProDe.get()),proDes);
        }
    }

    void delete(Integer projectId){
        proDe.removeIf(run->run.projectId().equals(projectId));
    }

    // Adding default database
    @PostConstruct
    public void init(){
        proDe.add(new ProjectDetails(
                1,
                "Codechum",
                "for improving students coding skills",
                "on Progress",
                LocalDateTime.now()
        ));
        proDe.add(new ProjectDetails(
                2,
                "LairEdu",
                "for assignments on students",
                "on Progress",
                LocalDateTime.now()
        ));
    }
}
