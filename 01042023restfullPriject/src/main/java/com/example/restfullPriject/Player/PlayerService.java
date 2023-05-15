package com.example.restfullPriject.Player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Service
public class PlayerService {

    private final PlayerRepository repository;
    @Autowired
    public PlayerService(PlayerRepository repository) {
        this.repository = repository;
    }

    public List<Player> getPlayers()    {
        return repository.findAll();

    }


    public void saveNewPlayer(Player player) {
        repository.save(player);
    }

    public void deleteById(Long playerId) {
        if (repository.existsById(playerId))    {
            repository.deleteById(playerId);
        }
    }
}
