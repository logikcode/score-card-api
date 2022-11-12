package com.decagon.scorecardapi.usecase.services.impl;

import com.decagon.scorecardapi.domain.entities.Admin;
import com.decagon.scorecardapi.domain.entities.Pod;
import com.decagon.scorecardapi.domain.entities.Squad;
import com.decagon.scorecardapi.domain.entities.Stack;
import com.decagon.scorecardapi.infrastructure.persistence.daoimpl.PodDaoImpl;
import com.decagon.scorecardapi.infrastructure.persistence.daoimpl.SquadDaoImpl;
import com.decagon.scorecardapi.infrastructure.persistence.daoimpl.StackDaoImpl;
import com.decagon.scorecardapi.infrastructure.persistence.repository.AdminRepository;
import com.decagon.scorecardapi.infrastructure.persistence.repository.PodRepository;
import com.decagon.scorecardapi.infrastructure.persistence.repository.SquadRepository;
import com.decagon.scorecardapi.usecase.payload.request.AdminDto;
import com.decagon.scorecardapi.usecase.services.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AdminServiceImpl implements AdminService {
//    private final PodDaoImpl podDao;
    private final PodRepository podRepository;
    private final StackDaoImpl stackDao;
    private final SquadDaoImpl squadDao;
    private final AdminRepository adminRepository;
    @Override
    public Admin createAdmin(AdminDto adminDto) {
        Admin admin = new Admin();
        admin.setFirstName(adminDto.getFirstName());
        admin.setLastName(adminDto.getLastName());
        admin.setEmail(adminDto.getEmail());
        admin.setAssignRole(adminDto.getRole());

//       Pod pod = podDao.getPod_ByPodName(adminDto.getPodName());
        Pod pod = podRepository.findByPodName(adminDto.getPodName()).orElse(null);
        Stack stack = stackDao.getAStackBy_AStackName(adminDto.getStackName());
        Squad squad = squadDao.getASquadFromDb(adminDto.getSquadName());
       admin.setPod(pod);
       admin.setStack(stack);
       admin.setSquad(squad);

       Admin savedAdmin = adminRepository.save(admin);
       return savedAdmin;
    }

    public Admin findAdminByFirst_andLastName(String firstName, String lastName){
        Optional<Admin> admin = adminRepository
                .findAdminByFirstNameIgnoreCaseAndLastNameIgnoreCase(firstName, lastName);
        return admin.orElse(null);
    }
}
