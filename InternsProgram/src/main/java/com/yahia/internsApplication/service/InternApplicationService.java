package com.yahia.internsApplication.service;

import com.yahia.internsApplication.model.DesiredTrack;
import com.yahia.internsApplication.model.intern.Intern;
import com.yahia.internsApplication.model.internApplication.*;
import com.yahia.internsApplication.repository.InternApplicationRepository;
import com.yahia.internsApplication.repository.InternRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class InternApplicationService {
    private final InternApplicationRepository internApplicationRepository;
    private final InternApplicationDtoMapper internApplicationDtoMapper;
    private final InternIdNameTrackDtoMapper internIdNameTrackDtoMapper;
    private final InternRepository internRepository;
    private final InternApplicationToInternMapper internApplicationToInternMapper;
    public List<InternApplicationDto> getAllInterns(){
        return internApplicationRepository.findAll().stream()
                .map(internApplicationDtoMapper)
                .collect(Collectors.toList());
    }
    public List<InternApplicationDto> getStudentsByUniversityAndTrackAndGpa(String university, DesiredTrack track, float gpa) {
        return internApplicationRepository.getInternByUniversityNameAndTrackAndGpaGreaterThan(university, track, gpa).
                stream().
                map(internApplicationDtoMapper).
                collect(Collectors.toList());
    }
    public List<InternApplicationDto> getInternByUniversityNameOrderByGpa(String uni){
        return internApplicationRepository.getInternByUniversityNameOrderByGpa(uni)
                .stream()
                .map(internApplicationDtoMapper)
                .collect(Collectors.toList());
    }

    public InternApplicationDto addIntern(InternApplicationDto internApplicationDto){
        InternApplication internApplication = InternApplication.builder().
                name(internApplicationDto.getName()).
                gpa(internApplicationDto.getGpa()).
                track(internApplicationDto.getTrack()).
                universityName(internApplicationDto.getUniversityName()).
                cvUrl(internApplicationDto.getCvUrl()).
                email(internApplicationDto.getEmail()).
                build();
        internApplicationRepository.save(internApplication);
        return internApplicationDtoMapper.apply(internApplication);
    }

    public void deleteInternById(Long id) {
        internApplicationRepository.deleteById(id);
    }

    public Integer acceptInternById(Long id, boolean accepted){
        if(accepted){
            InternApplication internApplication = internApplicationRepository.getById(id);
            Intern intern = internApplicationToInternMapper.apply(internApplication);
            internRepository.save(intern);
            return internApplicationRepository.acceptInternById(accepted, id);
        }
        else return -1;
    }

    public List<InternIdNameTrackDTO> getAllInternsIdNameTrack() {
        return internApplicationRepository.findAll().
                stream().
                map(internIdNameTrackDtoMapper).collect(Collectors.toList());
    }
}
