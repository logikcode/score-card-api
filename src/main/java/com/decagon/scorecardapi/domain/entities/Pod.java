package com.decagon.scorecardapi.domain.entities;

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
public class Pod {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
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
