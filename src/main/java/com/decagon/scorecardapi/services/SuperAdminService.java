package com.decagon.scorecardapi.services;


import com.decagon.scorecardapi.dto.requestdto.AdminDto;
import com.decagon.scorecardapi.model.User;

public interface SuperAdminService {
    User CreateAdmin(AdminDto adminDto, Long podId, Long stackId, Long squadId);

}
