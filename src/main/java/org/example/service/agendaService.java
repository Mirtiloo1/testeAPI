package org.example.service;

import org.example.entity.agenda;

import java.util.List;
import java.util.Optional;

public interface agendaService {
    agenda salvar(agenda agenda);

    List<agenda> listar();
    Optional<agenda> listar(int id);
}
