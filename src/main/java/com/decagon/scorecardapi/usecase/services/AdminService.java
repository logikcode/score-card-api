package com.decagon.scorecardapi.usecase.services;


import com.decagon.scorecardapi.domain.entities.Admin;
import com.decagon.scorecardapi.usecase.payload.request.AdminDto;

public interface AdminService {
    Admin createAdmin(AdminDto adminDto);
}
