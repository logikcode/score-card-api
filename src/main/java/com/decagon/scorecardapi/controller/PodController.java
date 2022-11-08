package com.decagon.scorecardapi.controller;
import com.decagon.scorecardapi.dto.PodRequestDto;
import com.decagon.scorecardapi.dto.PodResponseDto;
import com.decagon.scorecardapi.service.PodService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1")
public class PodController {
    private final PodService podService;

    @PostMapping("/super-admin/{stackId}/create-pod")
    public ResponseEntity<PodResponseDto> createPod(@PathVariable(name = "stackId") Long id,
                                                    @RequestBody PodRequestDto requestDto){
        return new ResponseEntity<>(podService.createPod(id, requestDto), HttpStatus.CREATED);
    }

    @PutMapping("/super-admin/update-pod/{podId}")
    public ResponseEntity<PodResponseDto> updatePod(@PathVariable(name = "podId") Long id,
                                                    @RequestBody PodRequestDto requestDto ){
        return new ResponseEntity<>(podService.updatePod(id, requestDto), HttpStatus.OK);
    }

}
