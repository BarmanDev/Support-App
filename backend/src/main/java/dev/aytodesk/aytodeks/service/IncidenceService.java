package dev.aytodesk.aytodeks.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.aytodesk.aytodeks.model.Incidence;
import dev.aytodesk.aytodeks.repository.IncidenceRepository;

@Service
public class IncidenceService {
    @Autowired
    private IncidenceRepository incidenceRepository;

    public List<Incidence> getAllIncidence() {
        return incidenceRepository.findAll();
    }

    public Incidence getIncidenceById(Long id) {
        return incidenceRepository.findById(id).orElse(null);
    }

    public Incidence createIncidence(Incidence incidence) {
        return incidenceRepository.save(incidence);
    }

    public Incidence updateIncidence(Incidence incidence) {
        return incidenceRepository.save(incidence);
    }

    public void deleteIncidenceById(Long id) {
        incidenceRepository.deleteById(id);
    }

}
