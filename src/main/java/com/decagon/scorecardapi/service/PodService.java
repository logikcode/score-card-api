

package com.decagon.scorecardapi.service;

import com.decagon.scorecardapi.dto.PodRequestDto;
import com.decagon.scorecardapi.dto.PodResponseDto;
import com.decagon.scorecardapi.model.Pod;

public interface PodService {
    PodResponseDto createPod(Long id, PodRequestDto requestDto);

    PodRequestDto updatePod(Long id, PodRequestDto requestDto);
}