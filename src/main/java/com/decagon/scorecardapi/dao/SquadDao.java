package com.decagon.scorecardapi.dao;

import com.decagon.scorecardapi.model.Squad;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SquadDao extends JpaRepository<Squad, Long> {

    @Override
    Page<Squad> findAll(Pageable pageable);
}
