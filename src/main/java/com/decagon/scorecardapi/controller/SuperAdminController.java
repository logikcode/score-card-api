package com.decagon.scorecardapi.controller;

import com.decagon.scorecardapi.model.Squad;
import com.decagon.scorecardapi.services.serviceimpl.SquadServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class SuperAdminController {

    private  SquadServiceImpl squadService;

    public SuperAdminController(SquadServiceImpl squadService){
        this.squadService = squadService;
    }

    @GetMapping("/super-admin/squads/{offset}/{pageSize}")
    public Page<Squad> getAllSquads(@PathVariable("offset") int offset,
                                    @PathVariable("pageSize") int pageSize){
        return squadService.getAllSquads(offset, pageSize);

    }

}
