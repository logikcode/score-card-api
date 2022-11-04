package com.decagon.scorecardapi.repository;

import com.decagon.scorecardapi.model.Squad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SquadRepository  extends JpaRepository<Squad, Long> {
    Squad findBySquadName(String squadName);
    boolean existsBySquadName(String squadName);


}
