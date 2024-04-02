package org.cangascup.backend.repository;

import org.cangascup.backend.models.Teams;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
    public interface TeamsRepository extends JpaRepository<Teams, Integer> {

    }
    
    


