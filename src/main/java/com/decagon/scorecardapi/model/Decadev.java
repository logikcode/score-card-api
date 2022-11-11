package com.decagon.scorecardapi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@DiscriminatorValue(value = "decadev")
@AllArgsConstructor
@NoArgsConstructor
public class Decadev extends User{

    private String decadevId;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "decadev_squad", referencedColumnName = "id")
    private Squad squad;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "decadev_stack", referencedColumnName = "id")
    private Stack stack;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "dev_pod",referencedColumnName = "id")
    private Pod pod;

    @JsonBackReference
    @OneToMany(mappedBy = "decadev")
    private List<WeeklyScore> weeklyScores = new ArrayList<>();

}