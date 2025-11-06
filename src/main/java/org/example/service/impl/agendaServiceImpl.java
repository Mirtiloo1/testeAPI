package org.example.service.impl;
import lombok.RequiredArgsConstructor;
import org.example.service.agendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.example.repository.agendaRepository;
import org.example.entity.agenda;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class agendaServiceImpl implements agendaService {
    @Autowired
    private agendaRepository agendaRepository;

    @Override
    public agenda salvar(agenda agenda) {
        return agendaRepository.save(agenda);
    }
    public List<agenda> listar(){
        return agendaRepository.findAll();
    }
    public Optional<agenda> listar(int id){
        return agendaRepository.findById(id);
    }
}