package com.decagon.scorecardapi.service;

import com.decagon.scorecardapi.dto.StackDto;
import com.decagon.scorecardapi.dto.responsedto.APIResponse;
import com.decagon.scorecardapi.model.StackTemplate;

public interface StackService {

      APIResponse <StackTemplate> createStack(StackDto stackDto);

}
