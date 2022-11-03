package com.decagon.scorecardapi.controller;

import com.decagon.scorecardapi.dto.responsedto.AllSquadResponse;
import com.decagon.scorecardapi.model.Squad;
import com.decagon.scorecardapi.services.serviceimpl.SquadServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1//super-admin")
public class SuperAdminController {
    private final SquadServiceImpl squadService;
    @GetMapping("/squads/{offset}/{pageSize}")
    public AllSquadResponse getAllSquads(@PathVariable("offset") int offset,
                                         @PathVariable("pageSize") int pageSize){
        return squadService.getAllSquads(offset, pageSize);
    }

}
