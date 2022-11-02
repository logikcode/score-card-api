package com.decagon.scorecardapi.domain.entities;

import com.decagon.scorecardapi.domain.entities.enums.AssignRole;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import javax.persistence.*;

@Entity
@Getter
@Setter
@DiscriminatorValue(value = "admin")
@AllArgsConstructor
@NoArgsConstructor
public class Admin extends User {
    @Enumerated(EnumType.STRING)
    private AssignRole assignRole;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "admin_squad", referencedColumnName = "id")
    private Squad squad;
    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "stack_admin",referencedColumnName = "id")
    private Stack stack;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "admin_pod",referencedColumnName = "id")
    private Pod pod;
}
