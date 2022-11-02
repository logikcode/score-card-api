package com.decagon.scorecardapi.infrastructure.controllers;

import com.decagon.scorecardapi.domain.entities.Squad;
import com.decagon.scorecardapi.usecase.services.SquadService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class SquadController {

    private final SquadService squadService;

    public SquadController(SquadService squadService) {
        this.squadService = squadService;
    }

    @GetMapping("/super-admin/squads/{offset}/{pageSize}")
    public Page<Squad> getAllSquads(@PathVariable("offset") int offset,
                                    @PathVariable("pageSize") int pageSize){
        return squadService.getAllSquads(offset, pageSize);

    }
}
