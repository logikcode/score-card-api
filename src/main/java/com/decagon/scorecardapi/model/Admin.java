package com.decagon.scorecardapi.model;

import com.decagon.scorecardapi.enums.AssignRole;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@DiscriminatorValue(value = "admin")
@AllArgsConstructor
@NoArgsConstructor
public class Admin extends User{
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
