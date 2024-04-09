package org.cangascup.backend.controllers;

import org.cangascup.backend.models.Teams;
import org.cangascup.backend.services.TeamsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/teams")
public class TeamsController {

    private final TeamsService teamsService;

    public TeamsController(TeamsService teamsService) {
        this.teamsService = teamsService;
    }

    @GetMapping
    public List<Teams> getAllTeams() {
        return teamsService.getAllTeams();
    }

    @GetMapping("/group")
    public Map<Integer, List<Teams>> getTeamsByGroup() {
        return teamsService.getTeamsByGroup_id();
    }

    @GetMapping("/ubication")
    public Map<String, List<Teams>> getTeamsByLocation() {
        return teamsService.getTeamsByLocation();
    }

    @PostMapping
    public ResponseEntity<Teams> addTeam(@RequestBody Teams team) {
        Teams newTeam = teamsService.addTeam(team);
        return new ResponseEntity<>(newTeam, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTeam(@PathVariable Integer id) {
        teamsService.deleteTeam(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Teams> updateTeam(@PathVariable Integer id, @RequestBody Teams team) {
        Teams updatedTeam = teamsService.updateTeam(id, team);
        return new ResponseEntity<>(updatedTeam, HttpStatus.OK);
    }
}
