package com.example.demo.team;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/team")
public class TeamController {

    private final TeamService teamService;

    @Autowired
    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping
    public List<Team> getTeam() {
      return teamService.getTeam();
    }

    @PostMapping
    public void registerNewTeam(@RequestBody Team team){
        teamService.addNewTeam(team);
    }

}
