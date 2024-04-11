package org.cangascup.backend.services;

import org.springframework.stereotype.Service;
import org.cangascup.backend.models.Team;
import org.cangascup.backend.repositories.TeamsRepository;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.NoSuchElementException;

@Service
public class TeamsService {

    private final TeamsRepository teamsRepository;

    public TeamsService(TeamsRepository teamsRepository) {
        this.teamsRepository = teamsRepository;
    }

    public List<Team> getAllTeams() {
        return teamsRepository.findAll();
    }

    public Map<Integer, List<Team>> getTeamsByGroup_id() {
        List<Team> allTeams = getAllTeams();
        return allTeams.stream().collect(Collectors.groupingBy(Team::getGroupId));
    }

    public Map<String, List<Team>> getTeamsByLocation() {
        List<Team> allTeams = getAllTeams();
        return allTeams.stream().collect(Collectors.groupingBy(Team::getUbication));
    }

    public Team addTeam(Team team) {
        if (team == null || team.getName() == null || team.getUbication() == null) {
            throw new IllegalArgumentException("Los datos del equipo son inválidos");
        }
        return teamsRepository.save(team);
    }

    public void deleteTeam(Integer id) {
        teamsRepository.deleteById(id);
    }

    public Team updateTeam(Integer id, Team updatedTeam) {
        if (updatedTeam == null || updatedTeam.getName() == null || updatedTeam.getUbication() == null) {
            throw new IllegalArgumentException("Los datos del equipo actualizado son inválidos");
        }

        Optional<Team> teamOptional = teamsRepository.findById(id);
        if (teamOptional.isPresent()) {
            Team existingTeam = teamOptional.get();
            existingTeam.setName(updatedTeam.getName());
            existingTeam.setUbication(updatedTeam.getUbication());
            existingTeam.setPoints(updatedTeam.getPoints());
            existingTeam.setGroup(updatedTeam.getGroupId());
            return teamsRepository.save(existingTeam);
        } else {
            throw new NoSuchElementException("No se encontró el equipo con el ID: " + id);
        }
    }
}
