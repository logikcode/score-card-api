package com.decagon.scorecardapi.controller;


import com.decagon.scorecardapi.dto.StackDto;
import com.decagon.scorecardapi.dto.responsedto.APIResponse;
import com.decagon.scorecardapi.model.StackTemplate;
import com.decagon.scorecardapi.service.StackService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class StackController {

    private final StackService stackService;

    @PostMapping("/super-admin/create-stack")
    public ResponseEntity<APIResponse<StackTemplate>> createStack(@RequestBody StackDto stackdto) {
        APIResponse<StackTemplate> stack = stackService.createStack(stackdto);
        return new ResponseEntity<>(stack, HttpStatus.CREATED);


    }
}
