package com.g1.appdev.francis_and_friends.project;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/runs")
public class ProjectDetailsController {
    private final ProjectDetailsRepository projectDetailsRepository;

    public ProjectDetailsController(ProjectDetailsRepository projectDetailsRepository){
        this.projectDetailsRepository = projectDetailsRepository;
    }
    // Reading part
    @GetMapping("/{id}")
    ProjectDetails findById(@PathVariable Integer projectId){
        Optional<ProjectDetails> proDe = projectDetailsRepository.findById(projectId);
        if(proDe.isEmpty()){
            throw new RuntimeException();
        }
        return proDe.get();
    }

    // Post
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    void create(@RequestBody ProjectDetails proDe){
        projectDetailsRepository.create(proDe);
    }

    // Put
    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping("/{id}")
    void update(@RequestBody ProjectDetails proDe, @PathVariable Integer projectId){
        projectDetailsRepository.update(proDe,projectId);
    }

    // Delete
    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer projectId){
        projectDetailsRepository.delete(projectId);
    }
}
