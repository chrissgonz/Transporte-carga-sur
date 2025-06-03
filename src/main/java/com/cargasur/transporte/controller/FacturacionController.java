package com.cargasur.transporte.controller;

import com.cargasur.transporte.model.Facturacion;
import com.cargasur.transporte.service.FacturacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
@RestController
@RequestMapping("/api/facturacion")
@CrossOrigin(origins = "*")
public class FacturacionController {

    @Autowired
    private FacturacionService facturacionService;

    @GetMapping
    public List<Facturacion> getAll() {
        return facturacionService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        return facturacionService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body((Facturacion) Collections.singletonMap("mensaje", "Factura no encontrada")));
    }

    @PostMapping
    public ResponseEntity<Facturacion> create(@RequestBody Facturacion facturacion) {
        return ResponseEntity.status(HttpStatus.CREATED).body(facturacionService.create(facturacion));
    }

    /*@PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Facturacion facturacion) {
        if (facturacionService.getById(id).isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Collections.singletonMap("mensaje", "Factura no encontrada"));
        }
        Facturacion updated = facturacionService.update(id, facturacion);
        return ResponseEntity.ok().body(updated);
    }*/

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        if (facturacionService.getById(id).isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Collections.singletonMap("mensaje", "Factura no encontrada"));
        }
        facturacionService.delete(id);
        return ResponseEntity.ok().body(Collections.singletonMap("mensaje", "Factura eliminada exitosamente"));
    }
}