package com.decagon.scorecardapi.repository;

import com.decagon.scorecardapi.model.Squad;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SquadRepository extends JpaRepository<Squad, Long> {

    Page<Squad> findAll(Pageable pageable);
}
