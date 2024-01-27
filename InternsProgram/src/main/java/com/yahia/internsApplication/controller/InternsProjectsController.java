package com.yahia.internsApplication.controller;

import com.yahia.internsApplication.model.internsProjects.InternsProjects;
import com.yahia.internsApplication.service.InternsProjectsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class InternsProjectsController {
    private final InternsProjectsService internsProjectsService;

    @GetMapping("/projects/view")
    public ResponseEntity<List<InternsProjects>> getAllProjects(){
        return new ResponseEntity<>(internsProjectsService.getAllProjects(), HttpStatus.OK);
    }
    @PostMapping("/projects/addIntern/")
    public ResponseEntity<InternsProjects> addInternToProject(@RequestParam Long intern_id,@RequestParam Long project_id){
        return new ResponseEntity<>(internsProjectsService.addInternToProject(intern_id,project_id), HttpStatus.OK);
    }
}
