package com.decagon.scorecardapi.service;


import com.decagon.scorecardapi.dto.responsedto.SquadDto;
import com.decagon.scorecardapi.dto.responsedto.StackResponseDto;
import com.decagon.scorecardapi.model.Squad;
import com.decagon.scorecardapi.model.Stack;
import org.springframework.data.domain.Page;


import com.decagon.scorecardapi.dto.requestdto.AdminDto;
import com.decagon.scorecardapi.model.User;

import java.util.List;

public interface SuperAdminService {
    User CreateAdmin(AdminDto adminDto, Long podId, Long stackId, Long squadId);

    String createSquad(SquadDto squadDto);

    Page<Squad> getAllSquads(int offset, int pageSize);

//    List<Stack> getAllStacks(Long squadId);

    List<StackResponseDto> getDetailsOfAllStacks(Long squadId);

}

