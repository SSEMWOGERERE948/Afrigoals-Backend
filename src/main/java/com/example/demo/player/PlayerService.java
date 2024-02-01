package com.example.demo.player;

import com.example.demo.player.Player;
import com.example.demo.player.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class PlayerService {

    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public List<Player> getPlayer() {
        return playerRepository.findAll();
    }

    public void addNewPlayer(Player player) {
        Optional<Player> teamOptional=playerRepository.findPlayerByName(player.getName());
        if (teamOptional.isPresent()){
            throw new IllegalStateException("player already exists");
        }
        playerRepository.save(player);
    }
}
