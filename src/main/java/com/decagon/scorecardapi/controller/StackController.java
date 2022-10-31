package com.decagon.scorecardapi.controller;


import com.decagon.scorecardapi.config.ApiResponse;
import com.decagon.scorecardapi.dto.StackDto;
import com.decagon.scorecardapi.service.StackService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
import java.util.Objects;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class StackController {

    private final StackService stackService;

    @PostMapping("/super-admin/create-stack")
    public ResponseEntity<ApiResponse> createStack(@Valid @RequestBody StackDto stackdto) {
        if(Objects.nonNull(stackService.checkStack(stackdto.getStackName()))){
            return new ResponseEntity<>(new ApiResponse(false, "Stack already exists"), HttpStatus.CONFLICT);
        }
        stackService.createStack(stackdto);

            return new ResponseEntity<>(new ApiResponse(true,"stack is created"),HttpStatus.CREATED);
    }
}
