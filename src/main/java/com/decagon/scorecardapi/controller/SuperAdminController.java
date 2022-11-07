
package com.decagon.scorecardapi.controller;

import com.decagon.scorecardapi.dto.requestdto.AdminDto;
import com.decagon.scorecardapi.dto.responsedto.APIResponse;
import com.decagon.scorecardapi.dto.responsedto.SquadDto;
import com.decagon.scorecardapi.model.Pod;
import com.decagon.scorecardapi.model.Squad;
import com.decagon.scorecardapi.model.User;
import com.decagon.scorecardapi.services.SuperAdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
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


    @PostMapping("/create-admin/{squadId}/{stackId}/{podId}")
    public ResponseEntity<APIResponse<?>> createAdmin(@RequestBody AdminDto adminDto, @PathVariable("podId") Long podId, @PathVariable("stackId") Long stackId, @PathVariable("squadId") Long squadId) {
        try {
            User admin = superAdminService.CreateAdmin(adminDto, podId, stackId, squadId);
            return new ResponseEntity(new APIResponse<>(true, "Admin created successfully", admin), HttpStatus.CREATED);
        } catch (Exception ex) {
            return new ResponseEntity<>(new APIResponse<>(false, ex.getMessage(), null), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/create-squad")
    public ResponseEntity<APIResponse<String>> createSquad (@RequestBody SquadDto squadDto) {

        return new ResponseEntity<>(new APIResponse<>(true,  superAdminService.createSquad(squadDto)), HttpStatus.CREATED);
    }

    @GetMapping("/squads/{offset}/{pageSize}")
    public ResponseEntity<Page<Squad>> getAllSquads(@PathVariable("offset") int offset,
                                                    @PathVariable("pageSize") int pageSize){
        Page<Squad> squads = superAdminService.getAllSquads(offset, pageSize);
        return  new ResponseEntity<>(squads, HttpStatus.OK);
    }
}

