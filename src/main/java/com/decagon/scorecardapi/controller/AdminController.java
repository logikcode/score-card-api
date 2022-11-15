package com.decagon.scorecardapi.controller;
import com.decagon.scorecardapi.dto.DecadevDto;
import com.decagon.scorecardapi.dto.responsedto.APIResponse;
import com.decagon.scorecardapi.model.Admin;
import com.decagon.scorecardapi.model.Decadev;
import com.decagon.scorecardapi.model.User;
import com.decagon.scorecardapi.service.AdminService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
public class AdminController {
    private final AdminService adminService;


    @PostMapping("/create-decadev/{squadId}/{stackId}/{podId}")
    public ResponseEntity<APIResponse<?>> createDecadev(@RequestBody DecadevDto decadevDto, @PathVariable("podId") Long podId, @PathVariable("stackId") Long stackId, @PathVariable("squadId") Long squadId) {
        User dev = adminService.createDecadev(decadevDto, podId, stackId, squadId);
        return new ResponseEntity<>(new APIResponse<>(true, "decadev created successfully", dev), HttpStatus.CREATED);

    }

    @PutMapping("/update-decadev/{squadId}/{stackId}/{podId}")
    public ResponseEntity<APIResponse<?>> updateDecadev (@RequestBody DecadevDto decadevDto, @PathVariable("podId") Long podId, @PathVariable("stackId") Long stackId, @PathVariable("squadId") Long squadId) {
        User dev = adminService.createDecadev(decadevDto, podId, stackId, squadId);
        return new ResponseEntity<>(new APIResponse<>(true, "decadev updated successfully", dev), HttpStatus.CREATED);

    }

    @GetMapping("/get-all-decadevs/{podId}")
    public ResponseEntity<APIResponse<?>> getAllDecadevs(@PathVariable("podId") Long podId) {
        List<DecadevDto> decadevs = adminService.getAllDecadevsFromAPod(podId);
        return new ResponseEntity<>(new APIResponse<>(true, "decadevs retrieved successfully", decadevs), HttpStatus.OK);
    }

}
