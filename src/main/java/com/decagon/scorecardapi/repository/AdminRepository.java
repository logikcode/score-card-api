package com.decagon.scorecardapi.repository;

import com.decagon.scorecardapi.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdminRepository extends JpaRepository<Admin, Long> {

    List<Admin> findAll();
}
