package org.cangascup.backend.repositories;

import java.util.List;

import org.cangascup.backend.models.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayersRepository extends JpaRepository<Player, Integer> {
 List<Player> findByNameContainingIgnoreCase(String name);
}
