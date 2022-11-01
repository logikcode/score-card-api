package com.decagon.scorecardapi.serviceImpl;

import com.decagon.scorecardapi.enums.Role;
import com.decagon.scorecardapi.model.User;
import com.decagon.scorecardapi.repository.UserRepository;
import com.decagon.scorecardapi.response.AdminResponse;
import com.decagon.scorecardapi.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@RequiredArgsConstructor
@Service
public class AdminServiceImpl implements AdminService {


    private final UserRepository userRepository;
    @Override
    public List<AdminResponse> getAllAdmin() {
        List<User> admins = userRepository.findAllByRole(Role.ADMIN);
        return null;
    }
}
