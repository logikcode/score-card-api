package com.decagon.scorecardapi.infrastructure.persistence.daoimpl;

import com.decagon.scorecardapi.domain.entities.Admin;
import com.decagon.scorecardapi.domain.entities.Pod;
import com.decagon.scorecardapi.infrastructure.persistence.repository.AdminRepository;
import com.decagon.scorecardapi.infrastructure.persistence.repository.PodRepository;
import com.decagon.scorecardapi.usecase.payload.request.PodDto;

import com.decagon.scorecardapi.usecase.services.impl.AdminServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PodDaoImpl {
    private final PodRepository podRepository;
    private final AdminServiceImpl adminService;

    public Pod createPod(PodDto podDto){
        Pod pod = new Pod();
        pod.setPodName(podDto.getPodName());
      String[] stackAssociateNames =
              podDto.getStackAssociateName().split(" ");
        String[] programAssociateNames = podDto.getProgramAssociateName().split(" ");

          String saFirstName = stackAssociateNames[0];
          String saLastName = stackAssociateNames[1];
          String paFirstName = programAssociateNames[0];
        String paLastName = programAssociateNames[1];

        Admin adminSa = adminService.findAdminByFirst_andLastName(saFirstName, saLastName);
        Admin adminPa = adminService.findAdminByFirst_andLastName(paFirstName, paLastName);

         List<Admin> admins = Arrays.asList(adminSa, adminPa);
         pod.setAdmin(admins);
         Pod savedPod = podRepository.save(pod);
         return savedPod;

    }

    public Pod getPod_ByPodName(String podName){
        Optional<Pod> pod = podRepository.findByPodName(podName);
        return pod.orElse(null);
    }
}
