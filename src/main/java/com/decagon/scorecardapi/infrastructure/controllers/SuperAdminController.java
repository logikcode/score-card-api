package com.decagon.scorecardapi.infrastructure.controllers;

import com.decagon.scorecardapi.domain.entities.Squad;
import com.decagon.scorecardapi.usecase.payload.request.SquadDto;
import com.decagon.scorecardapi.usecase.services.impl.SquadServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/super-admin")
public class SuperAdminController {

    private final SquadServiceImpl squadService;

    @GetMapping("/squads/{offset}/{pageSize}")
    public Page<Squad> getAllSquads(@PathVariable("offset") int offset,
                                    @PathVariable("pageSize") int pageSize){
        return squadService.getAllSquads(offset, pageSize);

    }
    //super-admin/create-squad
    @PostMapping("/create-squad")
    public  String createSquad(@RequestBody SquadDto squadDto){
        return  squadService.createSquad(squadDto);
    }

}
