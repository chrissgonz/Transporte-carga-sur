package com.cargasur.transporte.service;

import com.cargasur.transporte.model.Facturacion;
import com.cargasur.transporte.repository.FacturacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacturacionService {

    @Autowired
    private FacturacionRepository facturacionRepository;

    public List<Facturacion> getAll() {
        return facturacionRepository.findAll();
    }

    public Optional<Facturacion> getById(Integer id) {
        return facturacionRepository.findById(id);
    }

    public Facturacion create(Facturacion facturacion) {
        return facturacionRepository.save(facturacion);
    }

    public Optional<Facturacion> update(Integer id, Facturacion facturacion) {
        return facturacionRepository.findById(id).map(existing -> {
            existing.setOrden(facturacion.getOrden());
            existing.setUsuario(facturacion.getUsuario());
            existing.setMonto_total(facturacion.getMonto_total());
            existing.setFecha_emision(facturacion.getFecha_emision());
            existing.setEstado_pago(facturacion.getEstado_pago());
            return facturacionRepository.save(existing);
        });
    }

    public boolean delete(Integer id) {
        return facturacionRepository.findById(id).map(f -> {
            facturacionRepository.delete(f);
            return true;
        }).orElse(false);
    }
}
