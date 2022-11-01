package com.decagon.scorecardapi.repository;

import com.decagon.scorecardapi.enums.Role;
import com.decagon.scorecardapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository <User, Long>{

    List<User> findAllByRole(Role role);
}
