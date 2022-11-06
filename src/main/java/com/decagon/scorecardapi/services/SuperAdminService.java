package com.decagon.scorecardapi.services;


import com.decagon.scorecardapi.dto.responsedto.SquadDto;
import org.springframework.stereotype.Service;



import com.decagon.scorecardapi.dto.requestdto.AdminDto;
import com.decagon.scorecardapi.dto.responsedto.APIResponse;
import com.decagon.scorecardapi.dto.responsedto.SquadDto;
import com.decagon.scorecardapi.model.User;
import com.decagon.scorecardapi.response.ApiResponse;

public interface SuperAdminService {
    User CreateAdmin(AdminDto adminDto, Long podId, Long stackId, Long squadId);


    String createSquad(SquadDto squadDto);

    APIResponse getAdmin(Long id);
}

