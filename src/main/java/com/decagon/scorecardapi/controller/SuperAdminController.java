
package com.decagon.scorecardapi.controller;

import com.decagon.scorecardapi.dto.requestdto.AdminDto;

import com.decagon.scorecardapi.dto.responsedto.APIResponse;
import com.decagon.scorecardapi.dto.responsedto.SquadDto;
import com.decagon.scorecardapi.dto.responsedto.StackResponseDto;
import com.decagon.scorecardapi.model.Squad;
import com.decagon.scorecardapi.model.Stack;
import com.decagon.scorecardapi.services.SuperAdminService;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.LifecycleState;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import com.decagon.scorecardapi.model.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/super-admin")
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

    @GetMapping("/squads/{offset}/{pageSize}")
    public ResponseEntity<Page<Squad>> getAllSquads(@PathVariable("offset") int offset,
                                                    @PathVariable("pageSize") int pageSize){
        Page<Squad> squads = superAdminService.getAllSquads(offset, pageSize);
        return  new ResponseEntity<>(squads, HttpStatus.OK);
    }

//    @GetMapping("/{squadId}/stacks")
//    public ResponseEntity<List<Stack>> getAllStacks(@PathVariable("squadId") Long squadId){
//        List<Stack> stacks = superAdminService.getAllStacks(squadId);
//        return  new ResponseEntity<>(stacks, HttpStatus.OK);
//    }

    @GetMapping("/{squadId}/stacks")
    public ResponseEntity<List<StackResponseDto>> getDetailsOfAllStacks(@PathVariable("squadId") Long squadId){
        List<StackResponseDto> stacks = superAdminService.getDetailsOfAllStacks(squadId);
        return  new ResponseEntity<>(stacks, HttpStatus.OK);
    }
}

