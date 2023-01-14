package com.decagon.scorecardapi.repository;

import com.decagon.scorecardapi.model.Decadev;
import com.decagon.scorecardapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DecadevRepository extends JpaRepository<Decadev, Long> {
    // by Emmanuel
    Decadev findByDecadevId(String devId);

}
