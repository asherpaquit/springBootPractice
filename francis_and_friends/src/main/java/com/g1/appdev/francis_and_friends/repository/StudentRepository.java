package com.g1.appdev.francis_and_friends.repository;

import com.g1.appdev.francis_and_friends.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {
    // Additional custom queries can be defined here if needed
}
