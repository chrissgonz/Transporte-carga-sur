package com.cargasur.transporte.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cargasur.transporte.model.Orden;
import com.cargasur.transporte.service.OrdenService;
import com.cargasur.transporte.model.Cliente;
import com.cargasur.transporte.repository.ClienteRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.List;

@RestController
@RequestMapping("/api/ordenes")
@CrossOrigin(origins = "*")
public class OrdenController {

    @Autowired
    private OrdenService ordenService;
    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("/listarPorCliente/{clienteId}")
    public ResponseEntity<?> listarOrdenesPorCliente(@PathVariable Long clienteId) {
        List<Orden> ordenes = ordenService.getByClienteId(clienteId);
        if (ordenes.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("mensaje", "No se encontraron órdenes para el cliente"));
        }
        return ResponseEntity.ok(ordenes);
    }

    @PutMapping("/{id}/modificar")
    public ResponseEntity<?> modificarOrden(@PathVariable Long id, @RequestBody Orden orden) {
        Optional<Orden> existente = ordenService.getById(id);

        if (existente.isEmpty()) {
            return ResponseEntity.status(404).body("Orden no encontrada");
        }

        Integer clienteId = Integer.valueOf(orden.getCliente().getId());

        Optional<Cliente> clienteReal = clienteRepository.findById(clienteId);
        if (clienteReal.isEmpty()) {
            return ResponseEntity.status(400).body("Cliente no válido");
        }

        orden.setId(id);
        orden.setCliente(clienteReal.get());
        Orden actualizada = ordenService.update(orden);
        return ResponseEntity.ok(actualizada);
    }
}