package com.decagon.scorecardapi.utility;

import com.decagon.scorecardapi.repository.WeeklyScoreRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CalculateScores {

    private final WeeklyScoreRepository scoreRepository;

    public static Double weeklyCumulative(double as, double ws, double qa, double at, double wt) {
        return ((as * 0.15) + (ws * 0.15) + (qa * 0.1) + (at * 0.2) + (wt * 0.4));
    }
}
