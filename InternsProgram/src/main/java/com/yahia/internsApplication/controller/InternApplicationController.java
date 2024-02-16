package com.yahia.internsApplication.controller;

import com.yahia.internsApplication.model.DesiredTrack;
import com.yahia.internsApplication.model.internApplication.InternApplicationDto;
import com.yahia.internsApplication.model.internApplication.InternIdNameTrackDTO;
import com.yahia.internsApplication.service.InternApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;


import java.util.List;

@RestController
@RequiredArgsConstructor
public class InternApplicationController {
    private final InternApplicationService internApplicationService;
    @GetMapping("/internApplications/all")
    public ResponseEntity<List<InternApplicationDto>> getAllIterns(){
        List<InternApplicationDto> internDtos = internApplicationService.getAllInterns();
        return new ResponseEntity<>(internDtos, HttpStatus.OK);
    }
    @GetMapping("/internApplications/get/NameIdTrack")
    public ResponseEntity<List<InternIdNameTrackDTO>> getAllInternsIdNameTrack(){
        return new ResponseEntity<>(internApplicationService.getAllInternsIdNameTrack(), HttpStatus.OK);
    }
    @GetMapping("/internApplications/getBy/")
    public ResponseEntity<List<InternApplicationDto>> getStudentsByUniversityAndTrackAndGpa(
            @RequestParam String university,
            @RequestParam DesiredTrack track,
            @RequestParam float gpa
    ){
        List<InternApplicationDto> internApplicationDtos = internApplicationService.getStudentsByUniversityAndTrackAndGpa(university, track, gpa);
        return new ResponseEntity<>(internApplicationDtos, HttpStatus.OK);
    }
    @GetMapping("/internApplications/getBy/{universityName}")
    public List<InternApplicationDto> getInternByUniversity(@PathVariable("universityName") String uni){
        return  internApplicationService.getInternByUniversityNameOrderByGpa(uni);
    }

    @GetMapping("/internApplications/create")
    public ModelAndView RegistrationForm(ModelMap model) {
        model.addAttribute("formData", new InternApplicationDto());
        return new ModelAndView("/internApplications/create", model);
    }
    @PostMapping("/internApplications/create")
    public ModelAndView addIntern(@RequestBody @ModelAttribute("formData") InternApplicationDto internApplicationDto, ModelMap map){
        internApplicationService.addIntern(internApplicationDto);
        return new ModelAndView("/internApplications/success", map);
    }
    @PutMapping("/internApplications/accept/")
    public ResponseEntity<Integer> acceptInterById(@RequestParam Long id, @RequestParam boolean accept){
        return new ResponseEntity<>(internApplicationService.acceptInternById(id, accept), HttpStatus.OK);
    }
    @DeleteMapping("/internApplications/delete/")
    public void deleteInternById(@RequestParam Long id){
        internApplicationService.deleteInternById(id);
    }

}
