package com.yahia.internsApplication.model.internsProjects;

import com.yahia.internsApplication.model.intern.Intern;
import com.yahia.internsApplication.model.project.Project;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "interns_projects")
@IdClass(InternsProjectsPK.class)
public class InternsProjects {
//    @Id
//    @SequenceGenerator(
//            name = "interns_projects_id_sequence",
//            sequenceName = "interns_projects_id_sequence",
//            allocationSize = 1
//    )
//    @GeneratedValue(
//            strategy = GenerationType.SEQUENCE,
//            generator = "interns_projects_id_sequence"
//    )
//    private Long id;
    @Id
    @ManyToOne
    @JoinColumn(name = "intern_id")
    private Intern intern;
    @Id
    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

//    public InternsProjects(Intern intern, Project project) {
//        this.intern = intern;
//        this.project = project;
//    }
}
