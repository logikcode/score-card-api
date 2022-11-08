package com.decagon.scorecardapi.service;


import com.decagon.scorecardapi.dto.StackDto;
import com.decagon.scorecardapi.dto.requestdto.AdminDto;
import com.decagon.scorecardapi.dto.responsedto.APIResponse;
import com.decagon.scorecardapi.dto.responsedto.SquadDto;
import com.decagon.scorecardapi.model.Squad;
import com.decagon.scorecardapi.model.User;
import org.springframework.data.domain.Page;

public interface SuperAdminService {
    User CreateAdmin(AdminDto adminDto, Long podId, Long stackId, Long squadId);

    String createSquad(SquadDto squadDto);

    APIResponse getAdmin(Long id);
    Page<Squad> getAllSquads(int offset, int pageSize);

    APIResponse<String> updateStack(StackDto stackDto, Long id);

}
