package com.decagon.scorecardapi.controller;

import com.decagon.scorecardapi.dto.responsedto.APIResponse;
import com.decagon.scorecardapi.dto.responsedto.SquadDto;
import com.decagon.scorecardapi.services.SuperAdminService;
import com.decagon.scorecardapi.utility.Responder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/super-admin")
@RequiredArgsConstructor
public class SuperAdminController {

    private final SuperAdminService superAdminService;

    @PostMapping("/create-squad")
    public ResponseEntity<APIResponse<String>> createSquad (@RequestBody SquadDto squadDto) {

        return new ResponseEntity<>(new APIResponse<>(true,  superAdminService.createSquad(squadDto)), HttpStatus.CREATED);
    }

    @GetMapping(value ="/get-pod/{podId}")
    public ResponseEntity<APIResponse<?>> getPod(@PathVariable(value = "podId")Long id){
        return  Responder.successful(superAdminService.getPod(id));
    }


}