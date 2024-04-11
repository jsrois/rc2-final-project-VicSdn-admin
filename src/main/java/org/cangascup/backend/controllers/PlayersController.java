package org.cangascup.backend.controllers;

import java.util.List;

import org.cangascup.backend.models.Player;
import org.cangascup.backend.services.PlayersService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/players")
public class PlayersController {
    private final PlayersService playersService;

    public PlayersController(PlayersService playersService) {
        this.playersService = playersService;
    }

    @GetMapping
    public List<Player> getAllPlayers() {
        return playersService.getAllPlayers();
    }

    @PostMapping("/add")
    public Player addPlayer(@RequestBody Player player) {
        return playersService.addPlayer(player);
    }

    @PutMapping("/edit/{id}")
    public Player editPlayer(@PathVariable("id") Integer id, @RequestBody Player playerDetails) {
        return playersService.editPlayer(id, playerDetails);
    }

    @DeleteMapping("/delete/{id}")
    public void deletePlayer(@PathVariable("id") Integer id) {
        playersService.deletePlayer(id);
    }

    @GetMapping("/search")
    public List<Player> searchPlayersByName(@RequestParam("name") String name) {
        return playersService.searchPlayersByName(name);
    }
}
