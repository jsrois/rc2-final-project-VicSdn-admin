package org.cangascup.backend.services;

import org.springframework.stereotype.Service;
import org.cangascup.backend.models.Teams;
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

    public List<Teams> getAllTeams() {
        return teamsRepository.findAll();
    }

    public Map<Integer, List<Teams>> getTeamsByGroup_id() {
        List<Teams> allTeams = getAllTeams();
        return allTeams.stream().collect(Collectors.groupingBy(Teams::getGroup_id));
    }

    public Map<String, List<Teams>> getTeamsByLocation() {
        List<Teams> allTeams = getAllTeams();
        return allTeams.stream().collect(Collectors.groupingBy(Teams::getUbication));
    }

    public Teams addTeam(Teams team) {
        if (team == null || team.getName_team() == null || team.getUbication() == null) {
            throw new IllegalArgumentException("Los datos del equipo son inválidos");
        }
        return teamsRepository.save(team);
    }

    public void deleteTeam(Integer id) {
        teamsRepository.deleteById(id);
    }

    public Teams updateTeam(Integer id, Teams updatedTeam) {
        if (updatedTeam == null || updatedTeam.getName_team() == null || updatedTeam.getUbication() == null) {
            throw new IllegalArgumentException("Los datos del equipo actualizado son inválidos");
        }

        Optional<Teams> teamOptional = teamsRepository.findById(id);
        if (teamOptional.isPresent()) {
            Teams existingTeam = teamOptional.get();
            existingTeam.setName_team(updatedTeam.getName_team());
            existingTeam.setUbication(updatedTeam.getUbication());
            existingTeam.setPoints(updatedTeam.getPoints());
            existingTeam.setGroup(updatedTeam.getGroup_id());
            return teamsRepository.save(existingTeam);
        } else {
            throw new NoSuchElementException("No se encontró el equipo con el ID: " + id);
        }
    }
}
