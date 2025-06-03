package com.cargasur.transporte.controller;

import com.cargasur.transporte.model.Flota;
import com.cargasur.transporte.service.FlotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/flota")
@CrossOrigin(origins = "*")
public class FlotaController {

    @Autowired
    private FlotaService flotaService;

    @GetMapping
    public List<Flota> getAll() {
        return flotaService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        return flotaService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body((Flota) Collections.singletonMap("mensaje", "Camión no encontrado")));
    }

    @PostMapping
    public ResponseEntity<Flota> create(@RequestBody Flota flota) {
        return ResponseEntity.status(HttpStatus.CREATED).body(flotaService.create(flota));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Flota flota) {
        if (flotaService.getById(id).isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("mensaje", "Camión no encontrado"));
        }
        return ResponseEntity.ok().body(flotaService.update(id, flota));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        if (flotaService.getById(id).isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("mensaje", "Camión no encontrado"));
        }
        flotaService.delete(id);
        return ResponseEntity.ok().body(Map.of("mensaje", "Camión eliminado exitosamente"));
    }
}
