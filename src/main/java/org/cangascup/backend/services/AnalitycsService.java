package org.cangascup.backend.services;

import org.cangascup.backend.models.Analitycs;
import org.cangascup.backend.repositories.AnalitycsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnalitycsService {
    private final AnalitycsRepository analitycsRepository;

    public AnalitycsService(AnalitycsRepository analitycsRepository) {
        this.analitycsRepository = analitycsRepository;
    }

    public List<Analitycs> getAllAnalitycs() {
        return analitycsRepository.findAll();
    }

    public Analitycs addAnalitycs(Analitycs analitycs) {
        return analitycsRepository.save(analitycs);
    }

    public Analitycs editAnalitycs(Integer id, Analitycs analitycsDetails) {
        Analitycs analitycs = analitycsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Estadísticas no encontradas con ID: " + id));

        analitycs.setGoal(analitycsDetails.getGoal());
        analitycs.setAssist(analitycsDetails.getAssist());
        analitycs.setYellow_card(analitycsDetails.getYellow_card());
        analitycs.setRed_card(analitycsDetails.getRed_card());
        analitycs.setMvp(analitycsDetails.getMvp());

        return analitycsRepository.save(analitycs);
    }

    public void deleteAnalitycs(Integer id) {
        analitycsRepository.deleteById(id);
    }
}
