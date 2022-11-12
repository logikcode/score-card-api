package com.decagon.scorecardapi.usecase.payload.request;

import com.decagon.scorecardapi.domain.entities.enums.AssignRole;
import com.decagon.scorecardapi.domain.entities.enums.Role;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AdminDto {
    private String firstName;
    private String lastName;
    private String email;
    private AssignRole role;
    private String squadName;
    private  String podName;
    private String stackName;


}
