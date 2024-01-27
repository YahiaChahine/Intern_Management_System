package com.yahia.internsApplication.model.internApplication;

import com.yahia.internsApplication.model.DesiredTrack;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InternIdNameTrackDTO {
    private Long id;
    private String name;
    private DesiredTrack track;

}
