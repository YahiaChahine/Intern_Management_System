package com.yahia.internsApplication.model.internApplication;

import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class InternApplicationDtoMapper implements Function<InternApplication, InternApplicationDto> {
    @Override
    public InternApplicationDto apply(InternApplication internApplication) {
        return new InternApplicationDto(internApplication.getId(),
                internApplication.getName(),
                internApplication.getGpa(),
                internApplication.getCvUrl(),
                internApplication.getUniversityName(),
                internApplication.getTrack(),
                internApplication.isApplicationAcceptance(),
                internApplication.getEmail());
    }
}
