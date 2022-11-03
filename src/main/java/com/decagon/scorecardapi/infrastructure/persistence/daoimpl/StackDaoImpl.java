package com.decagon.scorecardapi.infrastructure.persistence.daoimpl;

import com.decagon.scorecardapi.domain.entities.Stack;
import com.decagon.scorecardapi.infrastructure.persistence.repository.StackRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class StackDaoImpl {

    private final StackRepository stackRepository;

    public List<Stack> getAllStacks(List<String> stacksForSquad){
        List<Stack> stacksList = stackRepository.findAll();
        if (stacksList.isEmpty()){
            stacksList = defaultStack(3, stacksForSquad);
        }
        return stacksList;
    }

    public Stack getAStackBy_AStackName(String stackName){
        Optional<Stack> stack = stackRepository.findByStackName(stackName);
        //do something
        return stack.orElse(null);

    }

    private List<Stack> defaultStack(int numberOf, List<String> stackNames){
        List<Stack> stacks = new ArrayList<>();
        int idx = 0;
        while (idx < numberOf){
            Stack stack = new Stack();
            stack.setStackName(stackNames.get(idx));
            stacks.add(stack);
            idx++;
        }
        return stacks;
    }
}
