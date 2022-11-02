package com.decagon.scorecardapi.usecase.services.impl;

import com.decagon.scorecardapi.domain.entities.Squad;
import com.decagon.scorecardapi.infrastructure.persistence.repository.SquadDao;
import com.decagon.scorecardapi.usecase.services.SquadService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SquadServiceImpl implements SquadService {
    private final SquadDao squadDao;
    public SquadServiceImpl(SquadDao squadDao){
        this.squadDao = squadDao;
    }
    @Override
    public Page<Squad> getAllSquads(int offset, int pageSize) {
        Pageable pageable = PageRequest.of(offset, pageSize);
        Page<Squad> squadPage = squadDao.findAll(pageable);
        return squadPage;
    }
}
