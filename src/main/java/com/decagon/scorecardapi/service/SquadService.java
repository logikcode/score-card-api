package com.decagon.scorecardapi.service;
import com.decagon.scorecardapi.dto.SquadDto;
import com.decagon.scorecardapi.model.Squad;


public interface SquadService {
    Squad createSquad (Long id, SquadDto squadDto);
}
