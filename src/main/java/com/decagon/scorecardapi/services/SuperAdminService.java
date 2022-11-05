package com.decagon.scorecardapi.services;

import com.decagon.scorecardapi.dto.responsedto.SquadDto;
import com.decagon.scorecardapi.model.Pod;
import org.springframework.stereotype.Service;


public interface SuperAdminService {
    String createSquad (SquadDto squadDto);

    Pod getPod(long id);
}
