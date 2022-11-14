package com.decagon.scorecardapi.service;

import com.decagon.scorecardapi.dto.DecadevDto;
import com.decagon.scorecardapi.dto.responsedto.APIResponse;
import com.decagon.scorecardapi.model.Decadev;
import com.decagon.scorecardapi.model.User;
import com.decagon.scorecardapi.response.AdminResponse;

import java.util.List;


public interface AdminService {
    List<AdminResponse> getAllAdmin();

   User createDecadev(DecadevDto dev, Long podId,Long stackId, Long squadId);

    APIResponse<Decadev> updateDecadev(DecadevDto decadevDto, Long decadevId, Long podId, Long stackId, Long squadId);

    List<DecadevDto> getAllDecadevsFromAPod(Long podId);
}

