package com.example.demo.SceduleMatch;


import com.example.demo.team.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/match")
public class MatchController {

    private final MatchService matchService;

    @Autowired
    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

    @GetMapping
    public List<Match> getMatch() {
        return matchService.getMatch();
    }

    @PostMapping
    public void registerNewMatch(@RequestBody Match match){
        matchService.addNewMatch(match);
    }

}

