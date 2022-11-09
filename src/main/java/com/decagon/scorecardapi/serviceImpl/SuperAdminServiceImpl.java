package com.decagon.scorecardapi.serviceImpl;

import com.decagon.scorecardapi.dto.StackDto;
import com.decagon.scorecardapi.dto.requestdto.AdminDto;
import com.decagon.scorecardapi.dto.responsedto.APIResponse;
import com.decagon.scorecardapi.dto.responsedto.SquadDto;
import com.decagon.scorecardapi.enums.Role;
import com.decagon.scorecardapi.exception.CustomException;
import com.decagon.scorecardapi.exception.ResourceNotFoundException;
import com.decagon.scorecardapi.exception.SquadAlreadyExistException;
import com.decagon.scorecardapi.exception.UserNotFoundException;
import com.decagon.scorecardapi.model.*;
import com.decagon.scorecardapi.repository.PodRepository;
import com.decagon.scorecardapi.repository.SquadRepository;
import com.decagon.scorecardapi.repository.StackRepository;
import com.decagon.scorecardapi.repository.UserRepository;
import com.decagon.scorecardapi.service.EmailService;
import com.decagon.scorecardapi.service.SuperAdminService;
import com.decagon.scorecardapi.utility.PasswordGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class SuperAdminServiceImpl implements SuperAdminService {


    private final PodRepository podRepository;
    private final UserRepository userRepository;
    private final SquadRepository squadRepository;
    private final StackRepository stackRepository;
    private final PasswordEncoder passwordEncoder;
    private final EmailService emailService;

    @Override
    public List<Pod> listOfPods() {
        return podRepository.findAll();
    }

    @Override
    public String removeAdminById(Long id) {
        if (userRepository.findById(id).isEmpty()) {
            throw new CustomException("User not found");
        } else {
            userRepository.deleteById(id);
            return "Admin deleted successfully";
        }

    }

    @Override
    public User CreateAdmin(AdminDto adminDto, Long podId, Long stackId, Long squadId) {
        if (userRepository.findByEmail(adminDto.getEmail()).isPresent()) {
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
        emailService.sendEmail("ScoreCard login details " + "password: " + password + " Email: " + admin.getEmail() + "\n",
                "You have been added as an admin", admin.getEmail());
        return userRepository.save(admin);
    }

    @Override

    public String createSquad(SquadDto squadDto) {
        if (squadRepository.existsBySquadName(squadDto.getSquadName())) {
            throw new SquadAlreadyExistException("Squad already exist");
        }
        Squad newSquad = new Squad();
        List<Stack> stacks = new ArrayList<>();

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
    public APIResponse getAdmin(Long id) {

        User admin = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("admin not found"));
        if (admin.getRole().equals(Role.ADMIN)) {
            return new APIResponse<>(true, "Successfully found an admin", admin);

        }
        return new APIResponse<>(true, "This person is not an admin", admin);
    }

    public Page<Squad> getAllSquads(int offset, int pageSize) {
        Pageable pageable = PageRequest.of(offset, pageSize);
        return squadRepository.findAll(pageable);
    }

    @Override
    public APIResponse<String> updateStack(StackDto stackDto, Long id) {
        Optional<Stack> optionalStack = stackRepository.findById(id);
        if (optionalStack.isEmpty()) {
            throw new ResourceNotFoundException("Stack", "", id);
        }
        Stack stack = optionalStack.get();
        stack.setStackName(stackDto.getStackName());
        stackRepository.save(stack);

        return new APIResponse<>(true, "Stack Updated Successfully");

    }

    public Stack getStackUsingId(Long id) {
       Optional<Stack> optionalStack = stackRepository.findById(id);
        if (optionalStack.isEmpty()) {
            throw new ResourceNotFoundException("Stack not found", "", id);
        }
       return optionalStack.get();
    }

    @Override
    public APIResponse<Admin> updateAdmin(AdminDto adminDto, Long adminId) {
        Admin adminName = (Admin) userRepository.findById(adminId).orElseThrow(() -> new CustomException("Admin not found"));
        adminName.setFirstName(adminDto.getFirstName());
        adminName.setLastName(adminDto.getLastName());
        adminName.setEmail(adminDto.getEmail());
        adminName.setRole(adminDto.getRole());
        adminName.setAssignRole(adminDto.getAssignRole());
        userRepository.save(adminName);
        return new APIResponse<>(true, "Admin updated successfully", adminName);
    }

    @Override
    public APIResponse<User> activateAdmin(Long adminId) {
        Admin admin = (Admin) userRepository.findById(adminId).orElseThrow(() -> new CustomException("Admin not found"));
         admin.activateUser();
        userRepository.save(admin);
        return new APIResponse<>(true, "Admin activated successfully", admin);
    }

    @Override
    public APIResponse<User> deactivateAdmin(Long adminId) {
        Admin admin = (Admin) userRepository.findById(adminId).orElseThrow(() -> new CustomException("Admin not found"));
        admin.deactivateUser();
        userRepository.save(admin);
        return new APIResponse<>(true, "Admin deactivated successfully", admin);
    }

}

