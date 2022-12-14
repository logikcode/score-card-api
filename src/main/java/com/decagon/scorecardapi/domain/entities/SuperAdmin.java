package com.decagon.scorecardapi.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue(value = "super_admin")
@Entity
public class SuperAdmin extends User {

    @OneToMany
    @JoinColumn(name = "superadmin_squad", referencedColumnName = "id")
    private List<Squad> squad;
    @OneToMany
    @JoinColumn(name = "superadmin_stack", referencedColumnName = "id")
    private List<Stack> stack;
    @OneToMany
    @JoinColumn(name = "superadmin_pod", referencedColumnName = "id")
    private List<Pod> pod;

}
