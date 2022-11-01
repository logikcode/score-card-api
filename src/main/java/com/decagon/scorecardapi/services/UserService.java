package com.decagon.scorecardapi.services;

import com.decagon.scorecardapi.dto.LoginDto;

public interface UserService {
    String login(LoginDto loginDto);
}
