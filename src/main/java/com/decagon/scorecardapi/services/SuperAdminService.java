package com.decagon.scorecardapi.services;

import com.decagon.scorecardapi.model.Pod;
import com.decagon.scorecardapi.model.Stack;

import java.util.List;

public interface SuperAdminService {

    List<Pod> listOfPods();

    void removeAdminById(Long id);
}
