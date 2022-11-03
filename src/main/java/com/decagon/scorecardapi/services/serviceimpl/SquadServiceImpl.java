package com.decagon.scorecardapi.services.serviceimpl;

import com.decagon.scorecardapi.dto.responsedto.AllSquadResponse;
import com.decagon.scorecardapi.repository.SquadRepository;
import com.decagon.scorecardapi.model.Squad;
import com.decagon.scorecardapi.services.SquadService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
@RequiredArgsConstructor
@Service
public class SquadServiceImpl implements SquadService {
    private final SquadRepository squadRepository;
    @Override
    public AllSquadResponse getAllSquads(int offset, int pageSize) {
        Pageable pageable = PageRequest.of(offset, pageSize);
        Page<Squad>  squads = squadRepository.findAll(pageable);
        AllSquadResponse allSquadResponse = AllSquadResponse.builder()
                .squads(squads)
                .build();
        return  allSquadResponse;
    }
}
