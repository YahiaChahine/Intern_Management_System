package com.yahia.internsApplication.model.internApplication;

import com.yahia.internsApplication.model.DesiredTrack;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InternApplicationDto {
    private Long id;
    private String name;
    private float gpa;
    private String cvUrl;
    private String universityName;
    private DesiredTrack track;
    private boolean applicationAcceptance;
    private String email;
}
