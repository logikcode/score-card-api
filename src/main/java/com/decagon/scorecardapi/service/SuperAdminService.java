package com.decagon.scorecardapi.service;

import com.decagon.scorecardapi.dto.requestdto.AdminDto;
import com.decagon.scorecardapi.dto.responsedto.SquadDto;
import com.decagon.scorecardapi.model.Pod;
import com.decagon.scorecardapi.model.Squad;
import com.decagon.scorecardapi.model.Stack;
import com.decagon.scorecardapi.model.User;
import org.springframework.data.domain.Page;

import java.util.List;

public interface SuperAdminService {

    List<Pod> listOfPods();

    String removeAdminById(Long id);

    User CreateAdmin(AdminDto adminDto, Long podId, Long stackId, Long squadId);

    String createSquad(SquadDto squadDto);

    Page<Squad> getAllSquads(int offset, int pageSize);

}

