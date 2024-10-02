package com.g1.appdev.francis_and_friends.controller;

import com.g1.appdev.francis_and_friends.entity.ProjectEntity;
import com.g1.appdev.francis_and_friends.repository.ProjectRepository;
import com.g1.appdev.francis_and_friends.entity.StudentEntity;
import com.g1.appdev.francis_and_friends.repository.StudentRepository; // Import the StudentRepository
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/project")
public class ProjectController {

    private static final Logger logger = LoggerFactory.getLogger(ProjectController.class);

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/findAll")
    public List<ProjectEntity> findAll() {
        return projectRepository.findAll();
    }

    @GetMapping("/{projectId}")
    public ProjectEntity findById(@PathVariable Integer projectId) {
        Optional<ProjectEntity> project = projectRepository.findById(projectId);
        if (project.isEmpty()) {
            logger.error("Project with ID {} not found", projectId);
            throw new RuntimeException("Project not found");
        }
        return project.get();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/add")
    public void create(@RequestBody ProjectEntity project) {

        if (project.getStudent() != null && project.getStudent().getStudentID() != null) {

            StudentEntity student = studentRepository.findById(project.getStudent().getStudentID())
                    .orElseThrow(() -> new RuntimeException("Student not found"));
            project.setStudent(student);
        }
        projectRepository.save(project);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping("/{projectId}")
    public void update(@RequestBody ProjectEntity project, @PathVariable Integer projectId) {
        if (!projectRepository.existsById(projectId)) {
            logger.error("Project with ID {} not found for update", projectId);
            throw new RuntimeException("Project not found");
        }
        project.setProjectID(projectId);
        logger.info("Updating project with ID {}: {}", projectId, project);
        projectRepository.save(project);
    }

    @DeleteMapping("/{projectId}")
    public void delete(@PathVariable Integer projectId) {
        if (!projectRepository.existsById(projectId)) {
            logger.error("Project with ID {} not found for deletion", projectId);
            throw new RuntimeException("Project not found");
        }
        projectRepository.deleteById(projectId);
        logger.info("Deleted project with ID {}", projectId);
    }
}
