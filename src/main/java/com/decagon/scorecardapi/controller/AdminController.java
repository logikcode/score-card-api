package com.decagon.scorecardapi.controller;

import com.decagon.scorecardapi.dto.WeeklyScoreDto;
import com.decagon.scorecardapi.dto.responsedto.APIResponse;
import com.decagon.scorecardapi.model.WeeklyScore;
import com.decagon.scorecardapi.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/admin")
public class AdminController {
    private final AdminService adminService;

    @PostMapping("/weekly-score/{devId}")
    public ResponseEntity<APIResponse<?>> weeklyScore(@PathVariable("devId")Long devId, @RequestBody WeeklyScoreDto score){
        try {
            WeeklyScore devScore = adminService.weeklyScore(score,devId);
            return new ResponseEntity<>(new APIResponse<>(true, "Weekly score populated successfully", devScore), HttpStatus.CREATED);
        } catch (Exception ex) {
            return new ResponseEntity<>(new APIResponse<>(false, ex.getMessage(), null), HttpStatus.BAD_REQUEST);
        }
    }
}
