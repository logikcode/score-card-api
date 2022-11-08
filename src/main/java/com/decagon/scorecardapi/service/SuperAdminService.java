package com.decagon.scorecardapi.service;


import com.decagon.scorecardapi.dto.StackDto;
import com.decagon.scorecardapi.dto.responsedto.SquadDto;
import com.decagon.scorecardapi.model.Squad;
import org.springframework.data.domain.Page;
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
    Page<Squad> getAllSquads(int offset, int pageSize);

    APIResponse<String> updateStack(StackDto stackDto, Long id);

}

