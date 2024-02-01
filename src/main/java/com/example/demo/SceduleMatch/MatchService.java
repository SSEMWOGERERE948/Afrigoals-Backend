package com.example.demo.SceduleMatch;



import com.example.demo.SceduleMatch.Match;
import com.example.demo.SceduleMatch.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class MatchService {

    private final MatchRepository matchRepository;

    @Autowired
    public MatchService(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    public List<Match> getMatch() {
        return matchRepository.findAll();
    }

    public void addNewTeam(Match match) {
        Optional<Match> teamOptional=matchRepository.findMatchByName(match.getName());
        if (teamOptional.isPresent()){
            throw new IllegalStateException("Match already exists");
        }
        matchRepository.save(match);
    }

    public void addNewMatch(Match match) {
    }
}

