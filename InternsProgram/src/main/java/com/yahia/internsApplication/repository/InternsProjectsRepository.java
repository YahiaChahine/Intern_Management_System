package com.yahia.internsApplication.repository;

import com.yahia.internsApplication.model.internsProjects.InternsProjects;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InternsProjectsRepository extends JpaRepository<InternsProjects, Long> {
}
