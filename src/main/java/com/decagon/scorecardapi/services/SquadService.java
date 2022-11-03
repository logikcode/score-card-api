package com.decagon.scorecardapi.services;

import com.decagon.scorecardapi.dto.responsedto.AllSquadResponse;
import com.decagon.scorecardapi.model.Squad;
import org.springframework.data.domain.Page;

public interface SquadService {
    AllSquadResponse getAllSquads(int offset, int pageSize);
}
