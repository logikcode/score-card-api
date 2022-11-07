package com.decagon.scorecardapi.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PodResponseDto {
    private  String podName;
    private String stackAssociateByEmail;
    private String programAssociateByEmail;


}
