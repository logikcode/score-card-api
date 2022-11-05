package com.decagon.scorecardapi.services;

import com.decagon.scorecardapi.dto.responsedto.SquadDto;
import org.springframework.stereotype.Service;


public interface SuperAdminService {
    String createSquad (SquadDto squadDto);
}