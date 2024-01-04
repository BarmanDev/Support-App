package dev.aytodesk.aytodeks.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.aytodesk.aytodeks.model.Incidence;
import dev.aytodesk.aytodeks.service.IncidenceService;

@RestController
@RequestMapping("api/v1/incidence")
@CrossOrigin(origins = "http://localhost:5173")
public class IncidenceController {

    @Autowired
    private IncidenceService incidenceService;

    @GetMapping
    public List<Incidence> listAll() {
        return incidenceService.getAllIncidence();

    }

    @GetMapping("/{id}")
    public Incidence getIncidence(@PathVariable Long id) {
        return incidenceService.getIncidenceById(id);
    }

    @PostMapping
    public Incidence creatIncidence(@RequestBody Incidence incidence) {
        return incidenceService.createIncidence(incidence);
    }

    @PostMapping("editIncidence/{id}")
    public Incidence updateIncidence(@RequestBody Incidence incidence, @PathVariable Long id) {
        incidence.setIdIncidence(id);
        return incidenceService.updateIncidence(incidence);
    }

    @DeleteMapping("deleteIncidence/{id}")
    public void deleteIncidence(@PathVariable Long id) {
        incidenceService.deleteIncidenceById(id);
    }
}
