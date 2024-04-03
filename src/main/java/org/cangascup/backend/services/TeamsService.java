package org.cangascup.backend.services;

import org.cangascup.backend.models.Teams;
import org.cangascup.backend.repositories.TeamsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamsService {

    private final TeamsRepository teamsRepository;

    public TeamsService(TeamsRepository teamsRepository) {
        this.teamsRepository = teamsRepository;
    }

    public List<Teams> getAllTeams() {
        return teamsRepository.findAll();
    }
}
