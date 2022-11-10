package com.decagon.scorecardapi.services.serviceimpl;


import com.decagon.scorecardapi.dto.requestdto.AdminDto;
import com.decagon.scorecardapi.dto.responsedto.SquadDto;
import com.decagon.scorecardapi.exception.PodNotFoundException;
import com.decagon.scorecardapi.exception.CustomException;
import com.decagon.scorecardapi.exception.SquadAlreadyExistException;
import com.decagon.scorecardapi.model.Pod;
import com.decagon.scorecardapi.model.Admin;
import com.decagon.scorecardapi.model.Squad;
import com.decagon.scorecardapi.model.Stack;
import com.decagon.scorecardapi.repository.PodRepository;
import com.decagon.scorecardapi.model.User;
import com.decagon.scorecardapi.repository.SquadRepository;
import com.decagon.scorecardapi.repository.StackRepository;
import com.decagon.scorecardapi.repository.UserRepository;
import com.decagon.scorecardapi.service.EmailService;
import com.decagon.scorecardapi.services.SuperAdminService;
import com.decagon.scorecardapi.utility.PasswordGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class SuperAdminServiceImpl implements SuperAdminService {


    private final SquadRepository squadRepository;
    private final StackRepository stackRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final EmailService emailService;

    private final PodRepository podRepository;

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

    @Override
    public Pod getPod(long id){

        return podRepository.findById(id).orElseThrow(()-> new PodNotFoundException(String.format("Pod with id %d not found",id)));
    }

    @Override
    public Page<Squad> getAllSquads(int offset, int pageSize) {
        Pageable pageable = PageRequest.of(offset, pageSize);
        return squadRepository.findAll(pageable);
    }
}

