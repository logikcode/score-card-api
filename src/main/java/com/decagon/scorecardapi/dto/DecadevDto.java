package com.decagon.scorecardapi.dto;
import com.decagon.scorecardapi.enums.Gender;
import com.decagon.scorecardapi.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DecadevDto {
    private String firstName;
    private String lastName;
    private Gender gender;
    private String email;
    private String decadevId;
    private Role role;


}
