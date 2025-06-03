package com.cargasur.transporte.controller;

import com.cargasur.transporte.model.Orden;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.cargasur.transporte.service.OrdenService;


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



    @GetMapping("/listarPorCliente/{clienteId}")
    public ResponseEntity<?> listarOrdenesPorCliente(@PathVariable Long clienteId) {
        List<Orden> ordenes = ordenService.getByClienteId(clienteId);
        if (ordenes.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("mensaje", "No se encontraron órdenes para el cliente"));
        }
        return ResponseEntity.ok(ordenes);
    }
}