package org.cangascup.backend.controllers;

import org.cangascup.backend.models.Analitycs;
import org.cangascup.backend.services.AnalitycsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/analitycs")
public class AnalitycsController {
    private final AnalitycsService analitycsService;

    public AnalitycsController(AnalitycsService analitycsService) {
        this.analitycsService = analitycsService;
    }

    @GetMapping
    public List<Analitycs> getAllAnalitycs() {
        return analitycsService.getAllAnalitycs();
    }

    @PostMapping
    public Analitycs addAnalitycs(@RequestBody Analitycs analitycs) {
        return analitycsService.addAnalitycs(analitycs);
    }

    @PutMapping("/{id}")
    public Analitycs editAnalitycs(@PathVariable Integer id, @RequestBody Analitycs analitycsDetails) {
        return analitycsService.editAnalitycs(id, analitycsDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteAnalitycs(@PathVariable Integer id) {
        analitycsService.deleteAnalitycs(id);
    }
}
