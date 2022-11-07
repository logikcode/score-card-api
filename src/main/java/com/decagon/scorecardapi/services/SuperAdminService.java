package com.decagon.scorecardapi.services;


import com.decagon.scorecardapi.dto.responsedto.SquadDto;
import com.decagon.scorecardapi.model.Pod;
import com.decagon.scorecardapi.model.Squad;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;



import com.decagon.scorecardapi.dto.requestdto.AdminDto;
import com.decagon.scorecardapi.dto.responsedto.SquadDto;
import com.decagon.scorecardapi.model.User;

public interface SuperAdminService {
    User CreateAdmin(AdminDto adminDto, Long podId, Long stackId, Long squadId);

    String createSquad(SquadDto squadDto);

    Page<Squad> getAllSquads(int offset, int pageSize);


    Pod getPod(long id);
}
