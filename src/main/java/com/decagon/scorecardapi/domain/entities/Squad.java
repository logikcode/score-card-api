package com.decagon.scorecardapi.domain.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Squad {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String squadName;
    @JsonManagedReference
    @ManyToMany
    @JoinColumn(name = "stack_squad", referencedColumnName = "id")
    private List<Stack> stack;

    @JsonManagedReference
    @ManyToMany
    @JoinColumn(name = "stack_admin", referencedColumnName = "id")
    private List<Admin> admin;

    @JsonBackReference
    @OneToMany(mappedBy = "squad")
    private List<Decadev> decadev;
}
