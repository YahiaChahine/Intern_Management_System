package com.yahia.internsApplication.service;

import com.yahia.internsApplication.model.intern.Intern;
import com.yahia.internsApplication.model.internsProjects.InternsProjects;
import com.yahia.internsApplication.model.project.Project;
import com.yahia.internsApplication.repository.InternRepository;
import com.yahia.internsApplication.repository.InternsProjectsRepository;
import com.yahia.internsApplication.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InternsProjectsService {
    private final InternsProjectsRepository internsProjectsRepository;
    private final InternRepository internRepository;
    private final ProjectRepository projectRepository;

    public InternsProjects addInternToProject(Long internId, Long projectId) {
        Intern intern = internRepository.findById(internId).orElse(null);
        Project project = projectRepository.findById(projectId).orElse(null);
        InternsProjects internsProjects = new InternsProjects(intern, project);
        internsProjectsRepository.save(internsProjects);
        return internsProjects;
    }

    public List<InternsProjects> getAllProjects() {
        return internsProjectsRepository.findAll();
    }
}
