package com.decagon.scorecardapi.controller;

import com.decagon.scorecardapi.dto.APIResponse;
import com.decagon.scorecardapi.dto.LoginDto;
import com.decagon.scorecardapi.dto.LoginResponse;
import com.decagon.scorecardapi.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class UserController {

    private  final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginDto loginDto) {

        return new ResponseEntity<>(new LoginResponse(true,"Successfully logged in", userService.login(loginDto)), HttpStatus.OK);
    }

}
