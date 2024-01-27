package com.yahia.internsApplication.model.internsProjects;

import com.yahia.internsApplication.model.intern.Intern;
import com.yahia.internsApplication.model.project.Project;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class InternsProjectsPK implements Serializable {
    private Intern intern;
    private Project project;
}
