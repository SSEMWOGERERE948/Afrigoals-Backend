package com.example.demo.SceduleMatch;

import com.example.demo.team.Team;
import com.example.demo.team.TeamRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.List;

@Configuration
public class MatchConfig {
    @Bean
    CommandLineRunner matchCommandLineRunner(
            MatchRepository matchRepository, TeamRepository teamRepository) {
        return args -> {
            // Retrieve teams from the database
            List<Team> teams = teamRepository.findAll();

            // Check if teams are present, if not, you may handle it accordingly

            // Schedule a match between the first two teams
            Team team1 = teams.get(0);
            Team team2 = teams.get(1);

            LocalDateTime matchTime = LocalDateTime.now().plusDays(7); // Schedule the match for a week from now

            // Additional match details (venue, referee, etc.) can be added based on your needs
            Match scheduledMatch = new Match("Friendly Match", team1, team2, matchTime, "Stadium ABC", "John Doe");

            // Save the scheduled match
            matchRepository.save(scheduledMatch);
        };
    }
}
