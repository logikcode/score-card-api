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

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Pod extends BaseClass{

    private  String podName;

    @JsonManagedReference
    @OneToMany(mappedBy = "pod")
    private List<Admin> admin = new ArrayList<>();

    @JsonManagedReference
    @OneToMany(mappedBy = "pod")
    private  List<Decadev> decadev = new ArrayList<>();

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "stack_pod", referencedColumnName = "id")
    private Stack stack;

}
