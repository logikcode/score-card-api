

package com.decagon.scorecardapi.service;

import com.decagon.scorecardapi.dto.PodRequestDto;
import com.decagon.scorecardapi.dto.PodResponseDto;
public interface PodService {
    PodResponseDto createPod(Long id, PodRequestDto requestDto);

    PodResponseDto updatePod(Long id, PodRequestDto requestDto);
}