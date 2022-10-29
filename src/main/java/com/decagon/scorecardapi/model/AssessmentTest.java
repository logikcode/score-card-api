package com.decagon.scorecardapi.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class AssessmentTest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;
    private double score;
    private String week;
    private String month;

    @JsonManagedReference
    @ManyToMany
    @JoinColumn(name = "dev_assess",referencedColumnName = "id")
    private List<Decadev> decadev = new ArrayList<>();
}
