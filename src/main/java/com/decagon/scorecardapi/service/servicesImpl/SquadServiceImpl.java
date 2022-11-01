package com.decagon.scorecardapi.service.servicesImpl;
import com.decagon.scorecardapi.dto.SquadDto;
import com.decagon.scorecardapi.exception.CustomException;
import com.decagon.scorecardapi.model.Squad;
import com.decagon.scorecardapi.model.Stack;
import com.decagon.scorecardapi.repository.SquadRepository;
import com.decagon.scorecardapi.repository.StackRepository;
import com.decagon.scorecardapi.service.SquadService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SquadServiceImpl implements SquadService {

    private final SquadRepository squadRepository;
    private final StackRepository stackRepository;

    @Override
    public Squad createSquad(Long id, SquadDto squadDto) {
        Squad squad = squadRepository.findBySquadName(squadDto.getSquadName());
        if (squad != null) {
            throw new CustomException("Squad already exist");
        }
        Stack superAdminStack = stackRepository.findById(id).orElseThrow(() ->new CustomException("Stack not found"));
        Squad newSquad = new Squad();
        newSquad.setSquadName(squadDto.getSquadName());
        newSquad.setStack((List<Stack>) superAdminStack);
        return squadRepository.save(newSquad);

    }
}
