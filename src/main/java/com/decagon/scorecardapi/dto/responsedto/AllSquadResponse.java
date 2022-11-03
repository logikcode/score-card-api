package com.decagon.scorecardapi.dto.responsedto;

import com.decagon.scorecardapi.model.Squad;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;

@AllArgsConstructor
public class AllSquadResponse {
    private Page<Squad> squads;
}
