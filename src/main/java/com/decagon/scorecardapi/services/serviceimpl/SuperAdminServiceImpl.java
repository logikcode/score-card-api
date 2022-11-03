package com.decagon.scorecardapi.services.serviceimpl;

import com.decagon.scorecardapi.dto.requestdto.AdminDto;
import com.decagon.scorecardapi.enums.Role;
import com.decagon.scorecardapi.services.SuperAdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.decagon.scorecardapi.exception.CustomException;
import com.decagon.scorecardapi.model.*;
import com.decagon.scorecardapi.repository.PodRepository;
import com.decagon.scorecardapi.repository.SquadRepository;
import com.decagon.scorecardapi.repository.StackRepository;
import com.decagon.scorecardapi.repository.UserRepository;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class SuperAdminServiceImpl implements SuperAdminService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final PodRepository podRepository;
    private final SquadRepository squadRepository;
    private final StackRepository stackRepository;

    @Override
    public User CreateAdmin(AdminDto adminDto, Long podId, Long stackId, Long squadId) {
        if (Objects.nonNull(userRepository.findByEmail(adminDto.getEmail()))) {
            throw new CustomException("User email already exist");
        }
        Pod adminPod = podRepository.findById(podId).orElseThrow();
        Squad adminSquad = squadRepository.findById(squadId).orElseThrow();
        Stack adminStack = stackRepository.findById(stackId).orElseThrow();
        Admin admin = new Admin();
        admin.setFirstName(adminDto.getFirstName());
        admin.setLastName(adminDto.getLastName());
        admin.setEmail(adminDto.getEmail());
        admin.setRole(Role.ADMIN);
        admin.setPod(adminPod);
        admin.setSquad(adminSquad);
        admin.setStack(adminStack);
        admin.setPassword(passwordEncoder.encode(adminDto.getPassword()));
        admin.setAssignRole(adminDto.getAssignRole());
        return userRepository.save(admin);
    }
}
