package com.cargasur.transporte.service;

import com.cargasur.transporte.model.Evento;
import com.cargasur.transporte.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventoService {

    @Autowired
    private EventoRepository eventoRepository;

    public List<Evento> getAll() {
        return eventoRepository.findAll();
    }

    public Optional<Evento> getById(Integer id) {
        return eventoRepository.findById(id);
    }

    public Evento create(Evento evento) {
        return eventoRepository.save(evento);
    }

    public Optional<Evento> update(Integer id, Evento evento) {
        return eventoRepository.findById(id).map(e -> {
            e.setOrden(evento.getOrden());
            e.setCamion(evento.getCamion());
            e.setFecha_evento(evento.getFecha_evento());
            e.setTipo_evento(evento.getTipo_evento());
            e.setDescripcion(evento.getDescripcion());
            e.setUbicacion(evento.getUbicacion());
            return eventoRepository.save(e);
        });
    }

    public boolean delete(Integer id) {
        return eventoRepository.findById(id).map(e -> {
            eventoRepository.delete(e);
            return true;
        }).orElse(false);
    }
}
