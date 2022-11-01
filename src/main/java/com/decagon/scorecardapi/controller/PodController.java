package com.decagon.scorecardapi.controller;

import com.decagon.scorecardapi.payLoad.APIResponse;
import com.decagon.scorecardapi.service.PodService;
import com.decagon.scorecardapi.util.Responder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/super-admin")
public class PodController {
    @Autowired
    PodService podService;

    @GetMapping(value ="/get-pod/{podId}")
    public ResponseEntity<APIResponse> getPod(@PathVariable(value = "podId")Long id){
    return  Responder.okay(podService.getPod(id));
    }

}
