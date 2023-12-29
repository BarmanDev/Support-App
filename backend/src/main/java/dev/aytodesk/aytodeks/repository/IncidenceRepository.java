package dev.aytodesk.aytodeks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.aytodesk.aytodeks.model.Incidence;

public interface IncidenceRepository extends JpaRepository<Incidence, Long> {

}