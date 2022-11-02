package com.decagon.scorecardapi.controller;

import com.decagon.scorecardapi.dto.requestdto.AdminDto;
import com.decagon.scorecardapi.dto.responsedto.APIResponse;
import com.decagon.scorecardapi.services.SuperAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.decagon.scorecardapi.model.User;

@RestController
@RequestMapping("/api/v1/super-admin")
public class SuperAdminController {

    private final SuperAdminService superAdminService;

    @Autowired
    public SuperAdminController(SuperAdminService superAdminService) {
        this.superAdminService = superAdminService;
    }

    @PostMapping("/create-admin/{squadId}/{stackId}/{podId}")
    public ResponseEntity<APIResponse<?>> createAdmin(@RequestBody AdminDto adminDto, @PathVariable("podId") Long podId, @PathVariable("stackId") Long stackId, @PathVariable("squadId") Long squadId) {
        try {
            User admin = superAdminService.CreateAdmin(adminDto, podId, stackId, squadId);
            return new ResponseEntity(new APIResponse<>(true, "Admin created successfully", admin), HttpStatus.CREATED);
        } catch (Exception ex) {
            return new ResponseEntity<>(new APIResponse<>(false, ex.getMessage(), null), HttpStatus.BAD_REQUEST);
        }
    }
}
