package com.decagon.scorecardapi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Stack {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String stackName;

    @JsonBackReference
    @OneToMany(mappedBy = "stack")
    private List<Pod> pods = new ArrayList<>();

    @JsonBackReference
    @OneToMany(mappedBy = "stack")
    private List<Decadev> decadev = new ArrayList<>();

    @JsonBackReference
    @OneToMany(mappedBy = "stack")
    private List<Admin> admin = new ArrayList<>();

    @JsonBackReference
    @ManyToMany(mappedBy = "stack")
    private List<Squad> squad = new ArrayList<>();



}
