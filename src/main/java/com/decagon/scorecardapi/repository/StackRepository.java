package com.decagon.scorecardapi.repository;

import com.decagon.scorecardapi.model.Stack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StackRepository extends JpaRepository<Stack, Long> {
//    List<Stack> findAllBySquadId(Long squadId);
//    List<Long> findAllStackIdBySquadId(Long squadId);
    List<Stack> findAllStackBySquadId(Long squadId);



}
