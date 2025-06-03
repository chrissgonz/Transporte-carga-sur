package com.cargasur.transporte.service;

import com.cargasur.transporte.model.Flota;
import com.cargasur.transporte.repository.FlotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlotaService {

    @Autowired
    private FlotaRepository flotaRepository;

    public List<Flota> getAll() {
        return flotaRepository.findAll();
    }

    public Optional<Flota> getById(Integer id) {
        return flotaRepository.findById(id);
    }

    public Flota create(Flota flota) {
        return flotaRepository.save(flota);
    }

    public Flota update(Integer id, Flota flota) {
        flota.setId_camion(id);
        return flotaRepository.save(flota);
    }

    public void delete(Integer id) {
        flotaRepository.deleteById(id);
    }
}
