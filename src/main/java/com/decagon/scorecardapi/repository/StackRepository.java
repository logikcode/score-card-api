package com.decagon.scorecardapi.repository;

import com.decagon.scorecardapi.model.Stack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface StackRepository extends JpaRepository<Stack,Long> {
    Stack findByStackName(String stackName);
    Optional<Stack> findById(Long id);

}
