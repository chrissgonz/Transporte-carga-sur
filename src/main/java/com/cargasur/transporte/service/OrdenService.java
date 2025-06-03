package com.cargasur.transporte.service;

import com.cargasur.transporte.model.Orden;
import com.cargasur.transporte.repository.OrdenRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OrdenService {

    @Autowired
    private OrdenRepository ordenRepository;

    public List<Orden> getByClienteId(Long ClienteId) {
        return ordenRepository.findByClienteId(ClienteId);
    }

    public Optional<Orden> getById(Long id) {
        return ordenRepository.findById(id);
    }

    public Orden create(Orden orden) {
        return ordenRepository.save(orden);
    }

    public Orden update(Orden orden) {
        return ordenRepository.save(orden);
    }

    public void delete(Long id) {
        ordenRepository.deleteById(id);
    }

    public List<Orden> findAll() {
        return ordenRepository.findAll();
    }
}
