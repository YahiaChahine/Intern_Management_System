package com.yahia.internsApplication.model.intern;

import com.yahia.internsApplication.model.DesiredTrack;
import com.yahia.internsApplication.model.Role;
import com.yahia.internsApplication.model.internsProjects.InternsProjects;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@EqualsAndHashCode
public class Intern {
    @Id
    @SequenceGenerator(
            name = "intern_id_sequence",
            sequenceName = "intern_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "intern_id_sequence"
    )
    @Column(name = "intern_id", updatable = false)
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
    @Column(name = "internshipEndDate")
    private Date internshipEndDate;
    @Column(name = "email")
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "intern", cascade = CascadeType.PERSIST)
    Set<InternsProjects> internsProjects;

    public Intern(String name, float gpa, String cvUrl, String universityName, DesiredTrack track, String email, String password) {
        this.name = name;
        this.gpa = gpa;
        this.cvUrl = cvUrl;
        this.universityName = universityName;
        this.track = track;
        this.email = email;
        this.password = password;
    }
}
