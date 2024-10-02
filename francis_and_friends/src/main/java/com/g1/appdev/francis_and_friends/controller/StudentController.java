package com.g1.appdev.francis_and_friends.controller;

import com.g1.appdev.francis_and_friends.dto.ProjectDetailsDTO;
import com.g1.appdev.francis_and_friends.entity.StudentEntity;
import com.g1.appdev.francis_and_friends.dto.StudentProjectDTO;
import com.g1.appdev.francis_and_friends.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private  StudentRepository studentRepository;

    @GetMapping("/findAll")
    public List<StudentEntity> findAll() {
        return studentRepository.findAll();
    }

    @GetMapping("/{studentId}")
    public StudentEntity findById(@PathVariable Integer studentId) {
        Optional<StudentEntity> student = studentRepository.findById(studentId);
        if (student.isEmpty()) {
            throw new RuntimeException("Student not found");
        }
        return student.get();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/add")
    public void create(@RequestBody StudentEntity student) {
        studentRepository.save(student);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping("/{studentId}")
    public void update(@RequestBody StudentEntity student, @PathVariable Integer studentId) {
        if (!studentRepository.existsById(studentId)) {
            throw new RuntimeException("Student not found");
        }
        student.setStudentID(studentId);
        studentRepository.save(student);
    }

    @DeleteMapping("/{studentId}")
    public void delete(@PathVariable Integer studentId) {
        if (!studentRepository.existsById(studentId)) {
            throw new RuntimeException("Student not found");
        }
        studentRepository.deleteById(studentId);
    }

    @GetMapping("/project")
    public List<StudentProjectDTO> getStudentsWithProjects() {
        List<StudentEntity> students = studentRepository.findAll();

        return students.stream().map(student -> {
            List<ProjectDetailsDTO> projects = student.getCourses().stream()
                    .map(course -> new ProjectDetailsDTO(course.getProjectID(), course.getTitle(), course.getDescription(), course.getStatus(), course.getDeadline()))
                    .collect(Collectors.toList());

            return new StudentProjectDTO(student.getStudentID(), student.getStudentFirstName(), student.getStudentLastName(), student.getEmail(), projects);
        }).collect(Collectors.toList());
    }
}
