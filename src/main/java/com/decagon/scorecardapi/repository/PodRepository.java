package com.decagon.scorecardapi.repository;

import com.decagon.scorecardapi.model.Pod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PodRepository extends JpaRepository<Pod,Long> {

}
