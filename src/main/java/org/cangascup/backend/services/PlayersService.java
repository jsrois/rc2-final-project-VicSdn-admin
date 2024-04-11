package org.cangascup.backend.services;

import java.util.List;
import java.util.Optional;

import org.cangascup.backend.models.Player;
import org.cangascup.backend.models.Team;
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

    public List<Player> getAllPlayers() {
        return playersRepository.findAll();
    }

    public Player addPlayer(Player player) {
        validatePlayerTeam(player);
        return playersRepository.save(player);
    }

    public Player editPlayer(Integer id, Player playerDetails) {
        Player player = playersRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Jugador no encontrado con ID: " + id));

        player.setName(playerDetails.getName());
        player.setSecondName(playerDetails.getSecondName());
        player.setDni(playerDetails.getDni());
        player.setTeamId(playerDetails.getTeamId());

        validatePlayerTeam(player);

        return playersRepository.save(player);
    }

    public void deletePlayer(Integer id) {
        playersRepository.deleteById(id);
    }

    public List<Player> searchPlayersByName(String name) {
        return playersRepository.findByNameContainingIgnoreCase(name);
    }

    private void validatePlayerTeam(Player player) {
        Integer teamId = player.getTeamId();
        if (teamId == null) {
            throw new IllegalArgumentException("El jugador debe tener un equipo asociado.");
        }

        Optional<Team> team = teamsRepository.findById(teamId);
        if (!team.isPresent()) {
            throw new IllegalArgumentException("No se encontró un equipo con el ID proporcionado.");
        }
    }
}
