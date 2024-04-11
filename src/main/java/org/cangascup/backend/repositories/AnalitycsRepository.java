package org.cangascup.backend.repositories;

import org.cangascup.backend.models.Analitycs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnalitycsRepository extends JpaRepository<Analitycs, Integer> {
}
