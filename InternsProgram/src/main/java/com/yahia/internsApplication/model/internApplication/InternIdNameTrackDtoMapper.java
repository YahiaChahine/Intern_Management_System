package com.yahia.internsApplication.model.internApplication;

import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class InternIdNameTrackDtoMapper implements Function<InternApplication, InternIdNameTrackDTO> {
    @Override
    public InternIdNameTrackDTO apply(InternApplication internApplication) {
        return new InternIdNameTrackDTO(
                internApplication.getId(),
                internApplication.getName(),
                internApplication.getTrack()
        );
    }
}
