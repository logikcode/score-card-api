package com.decagon.scorecardapi.dto.responsedto;

import lombok.Data;
@Data
public class DevDataResponse{
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private double algorithmScore;
    private  double weeklyAssessment;
    private double qaTest= 0;
    private double agileTest =0;
    private  double weeklyTask=0;
    private double cumulativeScore=0;
    private String week = String.valueOf(1);


}
