package com.cargasur.transporte.controller;

import com.cargasur.transporte.model.Evento;
import com.cargasur.transporte.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/eventos")
@CrossOrigin(origins = "*")
public class EventoController {

    @Autowired
    private EventoService eventoService;

    @GetMapping
    public List<Evento> getAll() {
        return eventoService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        return eventoService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body((Evento) Collections.singletonMap("mensaje", "Evento no encontrado")));
    }

    @PostMapping
    public ResponseEntity<Evento> create(@RequestBody Evento evento) {
        return ResponseEntity.status(HttpStatus.CREATED).body(eventoService.create(evento));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Evento evento) {
        if (eventoService.getById(id).isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body((Evento) Collections.singletonMap("mensaje", "Evento no encontrado"));
        }
        return ResponseEntity.ok().body(eventoService.update(id, evento).get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        if (eventoService.getById(id).isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body((Evento) Collections.singletonMap("mensaje", "Evento no encontrado"));
        }
        eventoService.delete(id);
        return ResponseEntity.ok().body(Collections.singletonMap("mensaje", "Evento eliminado exitosamente"));
    }
}
