package com.decagon.scorecardapi.controller;

import com.decagon.scorecardapi.model.Pod;
import com.decagon.scorecardapi.model.Stack;
import com.decagon.scorecardapi.services.SuperAdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class SuperAdminController {

    private  final SuperAdminService superAdminService;
    @GetMapping("/pods")
    public ResponseEntity<List<Pod>>getAllPods(){
        List<Pod>allPods = superAdminService.listOfPods();
        return new ResponseEntity<>(allPods,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteAdmin(@PathVariable("id") Long id){
        superAdminService.removeAdminById(id);
        return "Admin has been deleted successfully";
    }




}
