package com.decagon.scorecardapi.domain.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@DiscriminatorValue(value = "decadev")
@AllArgsConstructor
@NoArgsConstructor
public class Decadev extends User {

    private String decadevId;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "decadev_squad", referencedColumnName = "id")
    private Squad squad;
    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "decadev_stack", referencedColumnName = "id")
    private Stack stack;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "dev_pod",referencedColumnName = "id")
    private Pod pod;
    @JsonBackReference
    @ManyToMany(mappedBy = "decadev")
    private List<Algorithm> algorithm = new ArrayList<>();

    @JsonBackReference
    @ManyToMany(mappedBy = "decadev")
    private List<AgileTest> agileTests = new ArrayList<>();

    @JsonBackReference
    @ManyToMany(mappedBy = "decadev")
    private List<AssessmentTest> assessmentTests = new ArrayList<>();

    @JsonBackReference
    @ManyToMany(mappedBy = "decadev")
    private List<QATest> QATests = new ArrayList<>();

    @JsonBackReference
    @ManyToMany(mappedBy = "decadev")
    private List<WeeklyTask> weeklyTasks = new ArrayList<>();

}
