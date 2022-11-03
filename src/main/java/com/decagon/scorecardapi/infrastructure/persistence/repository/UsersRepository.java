package com.decagon.scorecardapi.infrastructure.persistence.repository;

import com.decagon.scorecardapi.domain.entities.Decadev;
import com.decagon.scorecardapi.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepository extends JpaRepository<User, Long> {


}
