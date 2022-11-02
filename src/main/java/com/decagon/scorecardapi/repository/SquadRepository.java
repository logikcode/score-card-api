package com.decagon.scorecardapi.repository;

import com.decagon.scorecardapi.model.Squad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SquadRepository extends JpaRepository<Squad, Long> {
}

