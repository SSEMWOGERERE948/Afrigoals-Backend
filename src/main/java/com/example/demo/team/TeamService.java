package com.example.demo.team;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class TeamService {

    private final TeamRepository teamRepository;

    @Autowired
    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public List<Team> getTeam() {
       return teamRepository.findAll();
    }

    public void addNewTeam(Team team) {
        Optional<Team> teamOptional=teamRepository.findTeamByName(team.getName());
        if (teamOptional.isPresent()){
            throw new IllegalStateException("Team already exists");
        }
        teamRepository.save(team);
    }
}
