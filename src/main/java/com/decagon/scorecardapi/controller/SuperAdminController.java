
package com.decagon.scorecardapi.controller;

import com.decagon.scorecardapi.dto.requestdto.AdminDto;

import com.decagon.scorecardapi.dto.responsedto.APIResponse;
import com.decagon.scorecardapi.dto.responsedto.SquadDto;
import com.decagon.scorecardapi.model.Squad;
import com.decagon.scorecardapi.services.SuperAdminService;
import com.decagon.scorecardapi.utility.Responder;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import org.springframework.web.bind.annotation.*;
import com.decagon.scorecardapi.model.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/super-admin")
@RequiredArgsConstructor
public class SuperAdminController {

    private final SuperAdminService superAdminService;
    @PostMapping("/create-admin/{squadId}/{stackId}/{podId}")
    public ResponseEntity<APIResponse<?>> createAdmin(@RequestBody AdminDto adminDto, @PathVariable("podId") Long podId, @PathVariable("stackId") Long stackId, @PathVariable("squadId") Long squadId) {
        try {
            User admin = superAdminService.CreateAdmin(adminDto, podId, stackId, squadId);
            return new ResponseEntity(new APIResponse<>(true, "Admin created successfully", admin), HttpStatus.CREATED);
        } catch (Exception ex) {
            return new ResponseEntity<>(new APIResponse<>(false, ex.getMessage(), null), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/create-squad")
    public ResponseEntity<APIResponse<String>> createSquad (@RequestBody SquadDto squadDto) {

        return new ResponseEntity<>(new APIResponse<>(true,  superAdminService.createSquad(squadDto)), HttpStatus.CREATED);
    }

    @GetMapping(value ="/get-pod/{podId}")
    public ResponseEntity<APIResponse<?>> getPod(@PathVariable(value = "podId")Long id){
        return  Responder.successful(superAdminService.getPod(id));
    }


    @GetMapping("/squads/{offset}/{pageSize}")
    public ResponseEntity<Page<Squad>> getAllSquads(@PathVariable("offset") int offset,
                                                    @PathVariable("pageSize") int pageSize){
        Page<Squad> squads = superAdminService.getAllSquads(offset, pageSize);
        return  new ResponseEntity<>(squads, HttpStatus.OK);
    }
}