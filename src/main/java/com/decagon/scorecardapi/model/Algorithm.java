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
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Algorithm {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;
    private double score;
    private String week;
    private String month;

    @JsonManagedReference
    @ManyToMany
    @JoinColumn(name = "dev_alg",referencedColumnName = "id")
    private List<Decadev> decadev = new ArrayList<>();


}
