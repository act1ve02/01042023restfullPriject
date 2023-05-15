package com.example.restfullPriject.Player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/users/auth")
public class PlayerController {
    private final PlayerService service;

    @Autowired
    public PlayerController(PlayerService service) {
        this.service = service;
    }

    @GetMapping
    public List<Player> getPlayers() {
        return service.getPlayers();
    }

    @PostMapping
    public void savePlayer(@RequestBody Player player) {
        service.saveNewPlayer(player);
    }

    @DeleteMapping
    public void deletePlayerByID(@RequestParam Long playerId) {
        service.deleteById(playerId);
    }

    @DeleteMapping(path = "deleteplayerbyname")
    public Player deletePlayerByName(@RequestParam String playerName) throws Exception {

        Optional<Player> player = Optional.ofNullable(service.getPlayers().stream()
                .filter(player1 -> player1.getName().equals(playerName))
                .findFirst()
                .orElseThrow( () -> new Exception("Player not found")));
        service.deleteById(player.get().getId());
        //System.out.println(player.get().getName());
        return player.get();
    }
}