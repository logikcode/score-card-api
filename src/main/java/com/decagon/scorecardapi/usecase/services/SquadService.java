package com.decagon.scorecardapi.usecase.services;

import com.decagon.scorecardapi.domain.entities.Squad;
import org.springframework.data.domain.Page;

public interface SquadService {
    Page<Squad> getAllSquads(int offset, int pageSize);
}
