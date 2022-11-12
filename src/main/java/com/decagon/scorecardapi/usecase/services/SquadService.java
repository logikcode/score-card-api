package com.decagon.scorecardapi.usecase.services;

import com.decagon.scorecardapi.domain.entities.Squad;
import com.decagon.scorecardapi.usecase.payload.request.SquadDto;
import org.springframework.data.domain.Page;

public interface SquadService {
    Page<Squad> getAllSquads(int offset, int pageSize);
    String createSquad(SquadDto squadDto);
//    Squad getSquad(String squadName);
}
