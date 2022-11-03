package com.decagon.scorecardapi.repository;

import com.decagon.scorecardapi.model.Pod;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PodRepository extends JpaRepository<Pod,Long> {
}
