package com.decagon.scorecardapi.response;

import com.decagon.scorecardapi.model.Admin;
import com.decagon.scorecardapi.model.User;
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

    public AdminResponse(Admin admin) {
        this.firstName = admin.getFirstName();
        this.lastName = admin.getLastName();
        this.email = admin.getEmail();
        this.squad = String.valueOf(admin.getSquad());
        this.stack = admin.getStack().getStackName();
        this.pod = admin.getPod().getPodName();

    }
}
