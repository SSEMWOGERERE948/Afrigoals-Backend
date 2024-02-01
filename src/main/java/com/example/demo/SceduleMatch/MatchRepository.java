package com.example.demo.SceduleMatch;

import com.example.demo.team.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MatchRepository extends JpaRepository<Match,Long> {

    @Query("SELECT s FROM Team s WHERE s.name = ?1")
    Optional<Match> findMatchByName(String name);
}
