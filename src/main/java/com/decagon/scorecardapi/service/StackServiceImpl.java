package com.decagon.scorecardapi.service;

import com.decagon.scorecardapi.dto.StackDto;
import com.decagon.scorecardapi.model.Stack;
import com.decagon.scorecardapi.repository.StackRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StackServiceImpl implements StackService{

    private final StackRepository stackRepository;

    @Override
    public Stack createStack(StackDto stackDto) {

        Stack newStack = new Stack();
        newStack.setStackName(stackDto.getStackName());
        return stackRepository.save(newStack);
    }

    @Override
    public Stack checkStack(String stackName) {
        return stackRepository.findByStackName(stackName);
    }


}
