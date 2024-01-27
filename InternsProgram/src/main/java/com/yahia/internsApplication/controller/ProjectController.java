package com.yahia.internsApplication.controller;

import com.yahia.internsApplication.model.project.Project;
import com.yahia.internsApplication.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProjectController {
    private final ProjectService projectService;

    @GetMapping("/projects/all")
    public ResponseEntity<List<Project>> getAllProjects(){
        return new ResponseEntity<>(projectService.getAllProjects(), HttpStatus.OK);
    }
    @PostMapping("/projects/add")
    public ResponseEntity<Project> addProject(@RequestBody Project project){
        return new ResponseEntity<>(projectService.addProject(project), HttpStatus.OK);
    }
}
