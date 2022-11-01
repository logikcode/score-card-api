package com.decagon.scorecardapi.services.impl;

import com.decagon.scorecardapi.dao.SquadDao;
import com.decagon.scorecardapi.model.Squad;
import com.decagon.scorecardapi.services.SquadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SquadServiceImpl implements SquadService {
    private final SquadDao squadDao;
    public SquadServiceImpl (SquadDao squadDao){
        this.squadDao = squadDao;
    }
    @Override
    public Page<Squad> getAllSquads(int offset, int pageSize) {
        Pageable pageable = PageRequest.of(offset, pageSize);
        Page<Squad> squadPage = squadDao.findAll(pageable);
        return squadPage;
    }
}
