package com.decagon.scorecardapi.infrastructure.persistence.daoimpl;

import com.decagon.scorecardapi.domain.entities.Squad;
import com.decagon.scorecardapi.infrastructure.persistence.repository.SquadRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class SquadDaoImpl {
    private final SquadRepository squadRepository;
    public Squad getASquadFromDb(String squadName){
        Optional<Squad>  squad = squadRepository.findBySquadName(squadName);
        return squad.orElse(null);
    }
}
