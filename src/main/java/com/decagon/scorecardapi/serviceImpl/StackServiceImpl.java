package com.decagon.scorecardapi.serviceImpl;

import com.decagon.scorecardapi.dto.StackDto;
import com.decagon.scorecardapi.dto.responsedto.APIResponse;
import com.decagon.scorecardapi.exception.StackAlreadyExistException;
import com.decagon.scorecardapi.model.Stack;
import com.decagon.scorecardapi.model.StackTemplate;
import com.decagon.scorecardapi.repository.StackRepository;
import com.decagon.scorecardapi.repository.StackTemplateRepository;
import com.decagon.scorecardapi.service.StackService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StackServiceImpl implements StackService {

    private final StackTemplateRepository stackTemplateRepository;

    @Override
    public APIResponse <StackTemplate> createStack(StackDto stackDto) {

       StackTemplate  stack = stackTemplateRepository.findByStackNameIgnoreCase(stackDto.getStackName());
        if (stack == null) {
            StackTemplate newStack = new StackTemplate();
            newStack.setStackName(stackDto.getStackName());
            stackTemplateRepository.save(newStack);
            return new APIResponse<>(true,"Stack Successfully Created",newStack);
        }else{
            return new APIResponse<>(true,"Stack already exist");

        }

    }


}
