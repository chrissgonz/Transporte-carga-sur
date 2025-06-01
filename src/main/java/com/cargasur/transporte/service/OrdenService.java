package com.cargasur.transporte.service;

import com.cargasur.transporte.model.Orden;
import com.cargasur.transporte.repository.OrdenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
import java.util.List;

@Service
public class OrdenService {

    @Autowired
    private OrdenRepository ordenRepository;

    public Orden crearOrden(Orden orden) {
        orden.setFechaCreacion(new Date());
        orden.setEstado("creada");
        return ordenRepository.save(orden);
    }

    public Optional<Orden> buscarOrdenPorId(Long id) {
        return ordenRepository.findById(id);
    }

    public List<Orden> buscarOrdenesPorClienteId(Long clienteId) {
        return ordenRepository.findByClienteId(clienteId);
    }
}
