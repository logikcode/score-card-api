package com.decagon.scorecardapi.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminResponse {
    private String firstName;
    private String lastName;
    private String email;
    private String squad;
    private String stack;
    private String pod;
    private String role;

}
