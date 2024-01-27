package com.yahia.internsApplication.service;

import com.yahia.internsApplication.model.project.Project;
import com.yahia.internsApplication.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectService {
    private final ProjectRepository projectRepository;
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public Project addProject(Project project) {
        projectRepository.save(project);
        return project;
    }
}
