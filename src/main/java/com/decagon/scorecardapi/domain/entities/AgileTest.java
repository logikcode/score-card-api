package com.decagon.scorecardapi.domain.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AgileTest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;
    private double score;
    private String week;
    private String month;

    @JsonManagedReference
    @ManyToMany
    @JoinColumn(name = "dev_agile",referencedColumnName = "id")
    private List<Decadev> decadev = new ArrayList<>();
}
