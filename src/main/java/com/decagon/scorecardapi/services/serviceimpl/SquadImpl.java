package com.decagon.scorecardapi.services.serviceimpl;

import com.decagon.scorecardapi.exception.SquadNotFoundException;
import com.decagon.scorecardapi.model.Squad;
import com.decagon.scorecardapi.repository.SquadRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SquadImpl implements com.decagon.scorecardapi.services.SquadImpl {
   private  final SquadRepository squadRepository;


    @Override
    public Squad getSquad(Long id) {
        Squad squad = squadRepository.findById(id).orElseThrow(()-> new SquadNotFoundException("Squad not found"));

        return squad;
    }
}
