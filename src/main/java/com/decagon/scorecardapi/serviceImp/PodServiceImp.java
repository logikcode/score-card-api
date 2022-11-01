package com.decagon.scorecardapi.serviceImp;

import com.decagon.scorecardapi.exception.PodNotFoundException;
import com.decagon.scorecardapi.model.Pod;
import com.decagon.scorecardapi.repository.PodRepository;
import com.decagon.scorecardapi.service.PodService;
import org.springframework.stereotype.Service;

@Service
public class PodServiceImp implements PodService {

   private  PodRepository podRepository;


    public Pod getPod(long id){

        return podRepository.findById(id).orElseThrow(()-> new PodNotFoundException(String.format("Pod with id %d not found",id)));
    }
}
