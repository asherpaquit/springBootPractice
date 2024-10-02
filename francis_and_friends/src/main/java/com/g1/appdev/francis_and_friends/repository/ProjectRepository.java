package com.g1.appdev.francis_and_friends.repository;

import com.g1.appdev.francis_and_friends.entity.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<ProjectEntity, Integer> {
    // Additional custom queries can be defined here if needed
}
