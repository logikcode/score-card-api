package com.decagon.scorecardapi.util;

import com.decagon.scorecardapi.payLoad.APIResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class Responder {
    public static ResponseEntity<APIResponse> successful(Object response){
        return  new  ResponseEntity<>(new APIResponse("Request Successful", true, response), HttpStatus.OK);
    }

}
