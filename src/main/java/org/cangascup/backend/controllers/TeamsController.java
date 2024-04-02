package org.cangascup.backend.controllers;

import org.cangascup.backend.models.Teams;
import org.cangascup.backend.services.TeamsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class TeamsController {
    private final TeamsService teamsService;

    
    public TeamsController(TeamsService teamsService) {
        this.teamsService = teamsService;
    }

    @GetMapping("/teams")
    public List<Teams> getAllTeams() {
        return teamsService.getAllTeams();
    }
}
