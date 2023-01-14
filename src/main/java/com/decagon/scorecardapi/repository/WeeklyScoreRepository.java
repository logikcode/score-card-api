package com.decagon.scorecardapi.repository;

import com.decagon.scorecardapi.model.Decadev;
import com.decagon.scorecardapi.model.WeeklyScore;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WeeklyScoreRepository extends JpaRepository<WeeklyScore,Long> {
    WeeklyScore findWeeklyScoreByWeekAndDecadev(String week, Decadev decadev);
    // added by Emmanuel
    WeeklyScore getWeeklyScoreByWeekAndDecadev_Id (String week, Long id);
    WeeklyScore getByWeekAndDecadev_Id(String week, Long id);
     void deleteByWeekAndDecadev_Id(String week, Long id);

    List<WeeklyScore> findWeeklyScoresByDecadev(Decadev decadev);
}
