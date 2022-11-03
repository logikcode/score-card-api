package com.decagon.scorecardapi.usecase.payload.request;


import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder
public class SquadDto {
    private String squadName;
    private List<String> stacks;
}
