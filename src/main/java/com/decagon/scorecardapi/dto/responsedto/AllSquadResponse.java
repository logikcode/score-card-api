package com.decagon.scorecardapi.dto.responsedto;

import com.decagon.scorecardapi.model.Squad;
import lombok.*;
import org.springframework.data.domain.Page;

@AllArgsConstructor
@Data
@Builder
public class AllSquadResponse {
    private Page<Squad> squads;
}
