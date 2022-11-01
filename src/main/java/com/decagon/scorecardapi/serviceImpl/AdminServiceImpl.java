package com.decagon.scorecardapi.serviceImpl;

import com.decagon.scorecardapi.model.Admin;
import com.decagon.scorecardapi.repository.AdminRepository;
import com.decagon.scorecardapi.response.AdminResponse;
import com.decagon.scorecardapi.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@RequiredArgsConstructor
@Service
public class AdminServiceImpl implements AdminService {

    private final AdminRepository adminRepository;
    @Override
    public List<AdminResponse> getAllAdmin() {
        List<Admin> admins = adminRepository.findAll();
        List<AdminResponse> adminResponses = new ArrayList<>();
        if (admins.size() != 0){
            for (Admin admin : admins){
                adminResponses.add(new AdminResponse(admin));
            }
        }
        return adminResponses;
    }
}
