package com.decagon.scorecardapi.services;

import com.decagon.scorecardapi.model.Squad;
import org.springframework.data.domain.Page;

public interface SquadService {
    Page<Squad> getAllSquads(int offset, int pageSize);
}
