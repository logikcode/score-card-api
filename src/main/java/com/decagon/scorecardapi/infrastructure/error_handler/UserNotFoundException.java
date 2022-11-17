package com.decagon.scorecardapi.infrastructure.error_handler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class UserNotFoundException extends Exception {

    private Long id;
    private  String message;

}
