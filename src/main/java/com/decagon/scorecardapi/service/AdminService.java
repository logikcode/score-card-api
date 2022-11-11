package com.decagon.scorecardapi.service;

import com.decagon.scorecardapi.dto.WeeklyScoreDto;
import com.decagon.scorecardapi.model.WeeklyScore;
import com.decagon.scorecardapi.response.AdminResponse;

import java.util.List;


public interface AdminService {
    List<AdminResponse> getAllAdmin();
     WeeklyScore weeklyScore(WeeklyScoreDto weeklyScoreDto, Long id);

}
