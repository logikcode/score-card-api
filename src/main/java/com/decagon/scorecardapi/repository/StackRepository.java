package com.decagon.scorecardapi.repository;

import com.decagon.scorecardapi.model.Stack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StackRepository extends JpaRepository<Stack,Long> {
}
