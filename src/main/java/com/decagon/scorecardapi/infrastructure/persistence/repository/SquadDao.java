package com.decagon.scorecardapi.infrastructure.persistence.repository;


import com.decagon.scorecardapi.domain.entities.Squad;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SquadDao extends JpaRepository<Squad, Long> {

    @Override
    Page<Squad> findAll(Pageable pageable);
}
