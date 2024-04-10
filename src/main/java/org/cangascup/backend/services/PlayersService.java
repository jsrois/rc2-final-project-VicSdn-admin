package org.cangascup.backend.services;

import java.util.List;
import java.util.Optional;

import org.cangascup.backend.models.Players;
import org.cangascup.backend.models.Teams;
import org.cangascup.backend.repositories.PlayersRepository;
import org.cangascup.backend.repositories.TeamsRepository;
import org.springframework.stereotype.Service;

@Service
public class PlayersService {
    private final PlayersRepository playersRepository;
    private final TeamsRepository teamsRepository;

    public PlayersService(PlayersRepository playersRepository, TeamsRepository teamsRepository) {
        this.playersRepository = playersRepository;
        this.teamsRepository = teamsRepository;
    }

    public List<Players> getAllPlayers() {
        return playersRepository.findAll();
    }

    public Players addPlayer(Players player) {
        validatePlayerTeam(player); // Validar que el jugador tenga un equipo asociado
        return playersRepository.save(player);
    }

    public Players editPlayer(Integer id, Players playerDetails) {
        Players player = playersRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Jugador no encontrado con ID: " + id));

        player.setName(playerDetails.getName());
        player.setSecond_name(playerDetails.getSecond_name());
        player.setDni(playerDetails.getDni());
        player.setID_team(playerDetails.getID_team());

        validatePlayerTeam(player); // Validar que el jugador tenga un equipo asociado

        return playersRepository.save(player);
    }

    public void deletePlayer(Integer id) {
        playersRepository.deleteById(id);
    }

    public List<Players> searchPlayersByName(String name) {
        return playersRepository.findByNameContainingIgnoreCase(name);
    }

    // Método para validar que el jugador tenga un equipo asociado
    private void validatePlayerTeam(Players player) {
        Integer teamId = player.getID_team();
        if (teamId == null) {
            throw new IllegalArgumentException("El jugador debe tener un equipo asociado.");
        }

        Optional<Teams> team = teamsRepository.findById(teamId);
        if (!team.isPresent()) {
            throw new IllegalArgumentException("No se encontró un equipo con el ID proporcionado.");
        }
    }
}
