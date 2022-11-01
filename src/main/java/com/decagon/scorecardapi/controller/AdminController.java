package com.decagon.scorecardapi.controller;

import com.decagon.scorecardapi.response.AdminResponse;
import com.decagon.scorecardapi.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class AdminController {
    private final AdminService adminService;

    @GetMapping("/admins")
    public ResponseEntity<?> getAllAdmin(){
        List<AdminResponse> admins = adminService.getAllAdmin();
        return new ResponseEntity<>(admins, HttpStatus.OK);
    }
}
