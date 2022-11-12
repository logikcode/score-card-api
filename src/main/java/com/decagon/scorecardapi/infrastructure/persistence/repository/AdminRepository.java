package com.decagon.scorecardapi.infrastructure.persistence.repository;

import com.decagon.scorecardapi.domain.entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    Optional<Admin> findAdminByFirstNameIgnoreCaseAndLastNameIgnoreCase(String firstName, String lastName);
}
