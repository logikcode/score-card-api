
package com.decagon.scorecardapi.controller;

import com.decagon.scorecardapi.dto.StackDto;
import com.decagon.scorecardapi.dto.requestdto.AdminDto;

import com.decagon.scorecardapi.dto.responsedto.APIResponse;
import com.decagon.scorecardapi.dto.responsedto.SquadDto;
import com.decagon.scorecardapi.model.Squad;


import com.decagon.scorecardapi.response.AdminResponse;
import com.decagon.scorecardapi.service.AdminService;
import com.decagon.scorecardapi.service.SuperAdminService;

import com.decagon.scorecardapi.serviceImpl.SquadImpl;
import lombok.RequiredArgsConstructor;
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


    private final SquadImpl squadImpl;


    private final AdminService adminService;
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


    @PostMapping("/get-squad/{id}")
    public ResponseEntity<APIResponse>getSquad(@PathVariable Long id) {
        return new ResponseEntity<>(new APIResponse<>(true, "Squad found", squadImpl.getSquad(id)), HttpStatus.OK);
    }

    @GetMapping("/get-admin{id}")
    public ResponseEntity<APIResponse> getAdmin(@PathVariable (value = "id")Long id){
        return new ResponseEntity<>(superAdminService.getAdmin(id),HttpStatus.OK);

    }




    @GetMapping("/squads/{offset}/{pageSize}")
    public ResponseEntity<Page<Squad>> getAllSquads(@PathVariable("offset") int offset,
                                                    @PathVariable("pageSize") int pageSize){
        Page<Squad> squads = superAdminService.getAllSquads(offset, pageSize);
        return  new ResponseEntity<>(squads, HttpStatus.OK);
    }

    @GetMapping("/admins")
    public ResponseEntity<?> getAllAdmin(){
        List<AdminResponse> admins = adminService.getAllAdmin();
        return new ResponseEntity<>(admins, HttpStatus.OK);
    }


    @PutMapping("/update-stack/{stackId}")
    public ResponseEntity<APIResponse<String>> updateAStack(@RequestBody StackDto stackDto,
                                                            @PathVariable Long stackId){
        return new ResponseEntity<>( superAdminService.updateStack(stackDto,stackId), HttpStatus.OK);
    }
}


