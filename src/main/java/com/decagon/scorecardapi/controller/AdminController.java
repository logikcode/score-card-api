package com.decagon.scorecardapi.controller;

import com.decagon.scorecardapi.dto.WeeklyScoreDto;
import com.decagon.scorecardapi.dto.responsedto.APIResponse;
import com.decagon.scorecardapi.model.WeeklyScore;
import com.decagon.scorecardapi.dto.DecadevDto;
import com.decagon.scorecardapi.model.User;
import com.decagon.scorecardapi.service.AdminService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1/admin")
public class AdminController {
    private final AdminService adminService;

    @PostMapping("/weekly-score/{devId}")
    public ResponseEntity<APIResponse<?>> weeklyScore(@PathVariable("devId") Long devId, @RequestBody WeeklyScoreDto score) {
        try {
            WeeklyScore devScore = adminService.decadevWeeklyScore(score, devId);
            return new ResponseEntity<>(new APIResponse<>(true, "Weekly score populated successfully", devScore), HttpStatus.CREATED);
        } catch (Exception ex) {
            return new ResponseEntity<>(new APIResponse<>(false, ex.getMessage(), null), HttpStatus.BAD_REQUEST);
        }
    }


    @PostMapping("/create-decadev/{squadId}/{stackId}/{podId}")
    public ResponseEntity<APIResponse<?>> createDecadev(@RequestBody DecadevDto decadevDto, @PathVariable("podId") Long podId, @PathVariable("stackId") Long stackId, @PathVariable("squadId") Long squadId) {
        User dev = adminService.createDecadev(decadevDto, podId, stackId, squadId);
        return new ResponseEntity<>(new APIResponse<>(true, "decadev created successfully", dev), HttpStatus.CREATED);

    }

    @DeleteMapping("/delete-decadev/{id}")
    public ResponseEntity<APIResponse<?>> deleteDecadev(@PathVariable("id") Long id) {
        try {
            adminService.deleteDecadev(id);
            return new ResponseEntity<>(new APIResponse<>(true, "decadev deleted successfully", null), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new APIResponse<>(false, e.getMessage(), null), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/updatee-decadev/{squadId}/{stackId}/{podId}")
    public ResponseEntity<APIResponse<?>> updateeDecadev(@RequestBody DecadevDto decadevDto, @PathVariable("podId") Long podId, @PathVariable("stackId") Long stackId, @PathVariable("squadId") Long squadId) {
        User dev = adminService.createDecadev(decadevDto, podId, stackId, squadId);
        return new ResponseEntity<>(new APIResponse<>(true, "decadev updated successfully", dev), HttpStatus.CREATED);

    }

}
