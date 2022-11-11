package com.decagon.scorecardapi.serviceImpl;

import com.decagon.scorecardapi.dto.WeeklyScoreDto;
import com.decagon.scorecardapi.exception.CustomException;
import com.decagon.scorecardapi.exception.UserNotFoundException;
import com.decagon.scorecardapi.model.Admin;
import com.decagon.scorecardapi.model.Decadev;
import com.decagon.scorecardapi.model.WeeklyScore;
import com.decagon.scorecardapi.repository.AdminRepository;
import com.decagon.scorecardapi.repository.DecadevRepository;
import com.decagon.scorecardapi.repository.WeeklyScoreRepository;
import com.decagon.scorecardapi.dto.DecadevDto;
import com.decagon.scorecardapi.exception.SquadNotFoundException;
import com.decagon.scorecardapi.exception.StackNotFoundException;
import com.decagon.scorecardapi.model.*;
import com.decagon.scorecardapi.repository.*;
import com.decagon.scorecardapi.response.AdminResponse;
import com.decagon.scorecardapi.service.AdminService;
import com.decagon.scorecardapi.utility.CalculateScores;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class AdminServiceImpl implements AdminService {

    private final AdminRepository adminRepository;
    private final DecadevRepository decadevRepository;
    private final WeeklyScoreRepository scoreRepository;
    private final UserRepository userRepository;
    private final PodRepository podRepository;
    private final StackRepository stackRepository;
    private final SquadRepository squadRepository;

    @Override
    public List<AdminResponse> getAllAdmin() {
        List<Admin> admins = adminRepository.findAll();
        List<AdminResponse> adminResponses = new ArrayList<>();
        if (admins.size() != 0) {
            for (Admin admin : admins) {
                adminResponses.add(new AdminResponse(admin));
            }
        }
        return adminResponses;
    }

    @Override
    public WeeklyScore decadevWeeklyScore(WeeklyScoreDto score, Long id) {
        Decadev dev = decadevRepository.findById(id).orElseThrow(
                () -> new UserNotFoundException("No Decadev with the ID: " + id));
        if (scoreRepository.findWeeklyScoreByWeekAndDecadev(score.getWeek(), dev) != null) {
            throw new CustomException("Weekly score already populated");
        }
        WeeklyScore devWeeklyScore = new WeeklyScore();
        double result = CalculateScores.weeklyCumulative(score.getWeeklyTask(),
                score.getAlgorithmScore(), score.getQaTest(), score.getAgileTest(), score.getWeeklyAssessment());
        devWeeklyScore.setAlgorithmScore(score.getAlgorithmScore());
        devWeeklyScore.setWeeklyAssessment(score.getWeeklyAssessment());
        devWeeklyScore.setQaTest(score.getQaTest());
        devWeeklyScore.setAgileTest(score.getAgileTest());
        devWeeklyScore.setWeeklyTask(score.getWeeklyTask());
        devWeeklyScore.setWeek(score.getWeek());
        devWeeklyScore.setDecadev(dev);
        devWeeklyScore.setCumulativeScore(result);
        return scoreRepository.save(devWeeklyScore);
    }

    public User createDecadev(DecadevDto decadev, Long podId, Long stackId, Long squadId) {
        if (userRepository.findByEmail(decadev.getEmail()).isPresent()) {
            throw new CustomException("User email already exist");
        }
        Pod pod = podRepository.findById(podId).orElseThrow(() -> new CustomException("Not found"));
        Stack stack = stackRepository.findById(stackId).orElseThrow(() -> new StackNotFoundException("Not found"));
        Squad squad = squadRepository.findById(squadId).orElseThrow(() -> new SquadNotFoundException("Not found"));
        Decadev dev = new Decadev();
        dev.setFirstName(decadev.getFirstName());
        dev.setLastName(decadev.getLastName());
        dev.setGender(decadev.getGender());
        dev.setEmail(decadev.getEmail());
        dev.setDecadevId(decadev.getDecadevId());
        dev.setRole(decadev.getRole());
        dev.setSquad(squad);
        dev.setStack(stack);
        dev.setPod(pod);

        return userRepository.save(dev);

    }

}
