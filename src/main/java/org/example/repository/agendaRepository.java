package org.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.example.entity.agenda;

public interface agendaRepository extends JpaRepository<agenda, Integer> {
}
