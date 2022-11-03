package com.decagon.scorecardapi.infrastructure.persistence.repository;

import com.decagon.scorecardapi.domain.entities.Squad;
import com.decagon.scorecardapi.domain.entities.Stack;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StackRepository extends JpaRepository<Stack, Long> {

    List<Stack> findAll();
    Optional<Stack> findByStackName(String stackName);
    List<Squad> findBySquad(Squad squads);

}
