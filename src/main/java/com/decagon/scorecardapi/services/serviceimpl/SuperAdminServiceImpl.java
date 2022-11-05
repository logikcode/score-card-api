package com.decagon.scorecardapi.services.serviceimpl;


import com.decagon.scorecardapi.dto.requestdto.AdminDto;
import com.decagon.scorecardapi.repository.PodRepository;
import com.decagon.scorecardapi.repository.SquadRepository;
import com.decagon.scorecardapi.services.EmailService;

import com.decagon.scorecardapi.dto.responsedto.SquadDto;
import com.decagon.scorecardapi.exception.SquadAlreadyExistException;
import com.decagon.scorecardapi.model.Squad;
import com.decagon.scorecardapi.model.Stack;

import com.decagon.scorecardapi.repository.SquadRepository;

import com.decagon.scorecardapi.repository.StackRepository;
import com.decagon.scorecardapi.services.SuperAdminService;
import com.decagon.scorecardapi.utility.PasswordGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.decagon.scorecardapi.exception.CustomException;
import com.decagon.scorecardapi.model.*;
import com.decagon.scorecardapi.repository.UserRepository;

import java.util.Objects;

import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SuperAdminServiceImpl implements SuperAdminService {


    private final SquadRepository squadRepository;
    private final StackRepository stackRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final EmailService emailService;

    @Override
    public User CreateAdmin(AdminDto adminDto, Long podId, Long stackId, Long squadId) {
        if (Objects.nonNull(userRepository.findByEmail(adminDto.getEmail()))) {
            throw new CustomException("User email already exist");
        }
        StringBuilder password = PasswordGenerator.generatePassword(10);
        Admin admin = new Admin();
        admin.setFirstName(adminDto.getFirstName());
        admin.setLastName(adminDto.getLastName());
        admin.setEmail(adminDto.getEmail());
        admin.setRole(adminDto.getRole());
        admin.setPassword(passwordEncoder.encode(password));
        admin.setAssignRole(adminDto.getAssignRole());
        emailService.sendEmail("ScoreCard login details "+ "password: "+ password+ " Email: "+ admin.getEmail() + "\n",
                "You have been added as an admin", admin.getEmail());
        return userRepository.save(admin);
    }
    @Override

    public String createSquad(SquadDto squadDto) {
        if (squadRepository.existsBySquadName(squadDto.getSquadName())) {
            throw new SquadAlreadyExistException("Squad already exist");
        }
        Squad newSquad = new Squad();
        List<Stack> stacks= new ArrayList<>();

        List<String> stackNames = squadDto.getStackNames();
        for (String stackName : stackNames) {
            Stack stack = new Stack();
            stack.setStackName(stackName);
            stackRepository.save(stack);
            stacks.add(stack);
        }
        newSquad.setSquadName(squadDto.getSquadName());
        newSquad.setStacks(stacks);
        squadRepository.save(newSquad);
        return "Squad created successfully";

    }


}

