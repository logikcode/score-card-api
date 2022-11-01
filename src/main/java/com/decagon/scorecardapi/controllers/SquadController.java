package com.decagon.scorecardapi.controllers;

import com.decagon.scorecardapi.dto.APIResponse;
import com.decagon.scorecardapi.dto.SquadDto;
import com.decagon.scorecardapi.model.Squad;
import com.decagon.scorecardapi.service.SquadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/v1")
public class SquadController {
    private final SquadService squadService;

    @Autowired
    public SquadController(SquadService squadService) {
        this.squadService = squadService;
    }

    @PostMapping("/super-admin/create-squad")
    public ResponseEntity<APIResponse<?>> createSquad ( Long id, @RequestBody SquadDto squadDto) {
        Squad superAdmin = squadService.createSquad(id, squadDto);
        return new ResponseEntity<>(new APIResponse<>(true, "Squad created successfully", superAdmin), HttpStatus.CREATED);
    }

}
