package com.decagon.scorecardapi.infrastructure.persistence.repository;

import com.decagon.scorecardapi.domain.entities.Pod;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PodRepository extends JpaRepository<Pod, Long> {
    Optional<Pod> findByPodName(String podName);
}
