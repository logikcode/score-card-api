package com.decagon.scorecardapi.infrastructure.persistence.repository;

import com.decagon.scorecardapi.domain.entities.Decadev;
import com.decagon.scorecardapi.domain.entities.Squad;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DecadevRepository extends JpaRepository<Decadev, Long> {
    Decadev findBySquad(Squad squad);
    List<Decadev> findAll();
    Decadev findByDecadevIdOrEmail(String decadevId, String email);
    List<Decadev> findAllBySquad(Squad squad);
    Decadev findByEmail(String email);
}
