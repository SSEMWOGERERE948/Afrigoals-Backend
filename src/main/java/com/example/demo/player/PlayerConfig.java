package com.example.demo.player;

import com.example.demo.team.Team;
import com.example.demo.team.TeamRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class PlayerConfig {

    @Bean
    CommandLineRunner playerCommandLineRunner(PlayerRepository playerRepository, TeamRepository teamRepository) {
        return args -> {
            // Retrieve teams from the database
            List<Team> teams = teamRepository.findAll();

            // Check if teams are present, if not, you may handle it accordingly

            // Create players with associated teams
            Player abdul = new Player(1L,"Abdul Lumala", teams.get(0)); // Assuming Vipers is the first team
            Player kigundu = new Player(2L,"Kigundu", teams.get(1)); // Assuming KCCA is the second team

            // Check if players with the same name already exist
            if (!playerRepository.existsByName(abdul.getName())) {
                playerRepository.save(abdul);
            }

            if (!playerRepository.existsByName(kigundu.getName())) {
                playerRepository.save(kigundu);
            }
        };
    }
}
