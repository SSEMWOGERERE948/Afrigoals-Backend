package com.example.demo.team;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class TeamConfig {
    @Bean
    CommandLineRunner commandLineRunner(
          TeamRepository repository) {
        return  args -> {

                 Team viper =   new Team(
                            1L,
                            "vipers"
            );
            Team kcca =   new Team(
                    2L,
                    "kcca"
            );
                 repository.saveAll(
                         List.of(viper,kcca)
                 );
        };
    }
}
