package com.yahia.internsApplication.model.internApplication;

import com.yahia.internsApplication.model.DesiredTrack;
import jakarta.persistence.*;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
@EqualsAndHashCode
@Entity(name = "InternApplication")
@Table(name = "applications")
public class InternApplication {

    @Id
    @SequenceGenerator(
            name = "internApplication_id_sequence",
            sequenceName = "internApplication_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "internApplication_id_sequence"
    )
    @Column(name = "application_id", updatable = false)
    private Long id;
    @Column(name = "name", nullable = false, columnDefinition = "TEXT")
    private String name;
    @Column(name = "gpa", nullable = false)
    private float gpa;
    @Column(name = "cvUrl", nullable = false)
    private String cvUrl;
    @Column(name = "university", nullable = false)
    private String universityName;
    @Column(name = "track", nullable = false)
    @Enumerated(EnumType.STRING)
    private DesiredTrack track;
    @Column(name = "application_acceptance")
    private boolean applicationAcceptance;
    @Column(name = "email")
    private String email;

}
