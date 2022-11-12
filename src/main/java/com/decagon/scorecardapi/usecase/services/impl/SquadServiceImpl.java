package com.decagon.scorecardapi.usecase.services.impl;

import com.decagon.scorecardapi.domain.entities.Squad;
import com.decagon.scorecardapi.domain.entities.Stack;
import com.decagon.scorecardapi.infrastructure.persistence.daoimpl.StackDaoImpl;
import com.decagon.scorecardapi.infrastructure.persistence.repository.SquadRepository;
import com.decagon.scorecardapi.infrastructure.persistence.repository.StackRepository;
import com.decagon.scorecardapi.usecase.payload.request.SquadDto;
import com.decagon.scorecardapi.usecase.services.SquadService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SquadServiceImpl implements SquadService {
    private final SquadRepository squadDao;
    private final StackDaoImpl stackDao;
    private final StackRepository stackRepository;
    @Override
    public Page<Squad> getAllSquads(int offset, int pageSize) {
        Pageable pageable = PageRequest.of(offset, pageSize);
        Page<Squad> squadPage = squadDao.findAll(pageable);
        return squadPage;
    }

    @Override
    public String createSquad(SquadDto squadDto) {
        // check if squad name already persisted

       Optional<Squad> squadInDb = squadDao.findBySquadName(squadDto.getSquadName());
       if (squadInDb.isPresent()){
           // inform that the referred squad already exist
       }
       Squad squad = new Squad();
       squad.setSquadName(squadDto.getSquadName());
        List<Stack> stacks = stackDao.getAllStacks(squadDto.getStacks());
        List<Stack> persistStacks = stackRepository.saveAll(stacks);
        squad.setStack(persistStacks);
        squadDao.save(squad);
        return "Squad Created Successfully";
    }


}
