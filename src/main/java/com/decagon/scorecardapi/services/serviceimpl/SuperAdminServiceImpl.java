package com.decagon.scorecardapi.services.serviceimpl;

import com.decagon.scorecardapi.model.Pod;
import com.decagon.scorecardapi.model.Stack;
import com.decagon.scorecardapi.repository.PodRepository;
import com.decagon.scorecardapi.repository.StackRepository;
import com.decagon.scorecardapi.repository.UserRepository;
import com.decagon.scorecardapi.services.SuperAdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
@RequiredArgsConstructor
public class SuperAdminServiceImpl implements SuperAdminService {


    private final PodRepository podRepository;
    private final UserRepository userRepository;

    @Override
    public List<Pod> listOfPods() {
        return podRepository.findAll();
    }

    @Override
    public void removeAdminById(Long id) {
        userRepository.deleteById(id);
    }


}
