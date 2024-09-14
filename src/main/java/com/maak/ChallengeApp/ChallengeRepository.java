package com.maak.ChallengeApp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


//CRUD
public interface ChallengeRepository extends JpaRepository<Challenge,Long> {
    Optional<Challenge> findByMonthIgnoreCase(String month);
}
