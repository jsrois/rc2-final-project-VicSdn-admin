package org.cangascup.backend.repositories;

import java.util.List;

import org.cangascup.backend.models.Players;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayersRepository extends JpaRepository<Players, Integer> {
 List<Players> findByNameContainingIgnoreCase(String name);
}
