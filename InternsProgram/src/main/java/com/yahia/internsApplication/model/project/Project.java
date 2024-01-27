package com.yahia.internsApplication.model.project;

import com.yahia.internsApplication.model.internsProjects.InternsProjects;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode
public class Project {
    @Id
    @SequenceGenerator(
            name = "project_id_sequence",
            sequenceName = "project_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "project_id_sequence"
    )
    @Column(name = "project_id")
    private Long id;
    private String project_name;
    private String description;
    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    Set<InternsProjects> internsProjects;
    private boolean completed;
}
