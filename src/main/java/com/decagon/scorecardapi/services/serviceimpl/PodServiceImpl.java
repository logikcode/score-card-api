package com.decagon.scorecardapi.services.serviceimpl;
import com.decagon.scorecardapi.dto.PodRequestDto;
import com.decagon.scorecardapi.dto.PodResponseDto;
import com.decagon.scorecardapi.exception.ResourceNotFoundException;
import com.decagon.scorecardapi.model.Admin;
import com.decagon.scorecardapi.model.Pod;
import com.decagon.scorecardapi.model.Stack;
import com.decagon.scorecardapi.repository.AdminRepository;
import com.decagon.scorecardapi.repository.PodRepository;
import com.decagon.scorecardapi.repository.StackRepository;
import com.decagon.scorecardapi.services.PodService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class PodServiceImpl implements PodService {
    private final PodRepository podRepository;
    private final StackRepository stackRepository;
    private final ModelMapper modelMapper;
    private final AdminRepository adminRepository;


    @Override
    public PodResponseDto createPod(Long id, PodRequestDto requestDto) {
        List<Admin> adminList = new ArrayList();
        Stack stack = stackRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("stackname", "id", id));
        Admin stackAssociate = adminRepository.findAdminByEmail(requestDto.getStackAssociateByEmail()).orElseThrow(()->new ResourceNotFoundException("stack Associate", "id", id));

        Admin programAssociate = adminRepository.findAdminByEmail(requestDto.getProgramAssociateByEmail()).orElseThrow(()->new ResourceNotFoundException("stack Associate", "id", id));
        adminList.add(stackAssociate);
        adminList.add(programAssociate);

        Pod pod = new Pod();
        pod.setStack(stack);
        pod.setPodName(requestDto.getPodName());
        pod.setAdmin(adminList);
        return modelMapper.map(podRepository.save(pod), PodResponseDto.class);

    }

    @Override
    public PodResponseDto updatePod(Long id, PodRequestDto requestDto) {

        return podRepository.findById(id).map(podUpdate-> {
            modelMapper.map(requestDto, podUpdate);
            Pod updated = podRepository.save(podUpdate);
            return modelMapper.map(updated, PodResponseDto.class);
        }).orElseThrow(()-> new ResourceNotFoundException("pod not found", "id", id));
    }
}