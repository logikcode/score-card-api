package com.decagon.scorecardapi.usecase.services.impl;

import com.decagon.scorecardapi.domain.entities.Admin;
import com.decagon.scorecardapi.domain.entities.Pod;
import com.decagon.scorecardapi.infrastructure.persistence.daoimpl.PodDaoImpl;
import com.decagon.scorecardapi.usecase.payload.request.AdminDto;
import com.decagon.scorecardapi.usecase.payload.request.PodDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SuperAdminServiceImpl {
    private final PodDaoImpl podDao;
    private final AdminServiceImpl adminService;

    public String createPod(PodDto podDto){
       Pod pod = podDao.createPod(podDto);
       if (pod != null)
           return "Pod Created Successfully";
       return "Error Creating A Pod";
    }
    public String creatAnAdmin(AdminDto adminDto){
        Admin admin = adminService.createAdmin(adminDto);
        if (admin != null){
            return "Admin Created";
        }
        return "Could not create admin";
    }

}
