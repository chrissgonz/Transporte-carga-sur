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

@RestController
@RequestMapping("/api/ordenes")
@CrossOrigin(origins = "*")
public class OrdenController {

    @Autowired
    private OrdenService ordenService;

    @GetMapping("/{id}/estado")
    public ResponseEntity<Map<String, String>> obtenerEstadoOrden(@PathVariable Long id) {
        Optional<Orden> ordenOpt = ordenService.buscarOrdenPorId(id);

        if (ordenOpt.isPresent()) {
            Map<String, String> respuesta = new HashMap<>();
            respuesta.put("estado", ordenOpt.get().getEstado());
            return ResponseEntity.ok(respuesta);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
