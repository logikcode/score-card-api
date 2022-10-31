package com.decagon.scorecardapi.service;

import com.decagon.scorecardapi.dto.StackDto;
import com.decagon.scorecardapi.model.Stack;

public interface StackService {

      Stack createStack( StackDto stackDto);

      Stack checkStack(String stackName);
}
