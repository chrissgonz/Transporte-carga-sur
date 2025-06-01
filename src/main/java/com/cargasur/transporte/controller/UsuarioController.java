package com.cargasur.transporte.controller;

import com.cargasur.transporte.model.Usuario;
import com.cargasur.transporte.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> datos) {
        String correo = datos.get("correo");
        String clave = datos.get("clave");

        Optional<Usuario> usuario = usuarioRepository.findByCorreoAndClave(correo, clave);

        if (usuario.isPresent()) {
            Usuario u = usuario.get();
            Map<String, Object> respuesta = new HashMap<>();
            respuesta.put("id", u.getId());
            respuesta.put("correo", u.getCorreo());
            respuesta.put("rol", u.getRol());
            respuesta.put("mensaje", "Login exitoso");

            return ResponseEntity.ok(respuesta);
        } else {
            return ResponseEntity.status(401).body(Map.of("mensaje", "Credenciales inválidas"));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerUsuario(@PathVariable Long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);

        if (usuario.isPresent()) {
            Usuario u = usuario.get();
            Map<String, Object> datos = new HashMap<>();
            datos.put("id", u.getId());
            datos.put("correo", u.getCorreo());
            datos.put("rol", u.getRol());
            datos.put("mensaje", "Perfil obtenido correctamente");

            return ResponseEntity.ok(datos);
        }

        return ResponseEntity.status(404).body(Map.of("mensaje", "Usuario no encontrado"));
    }
}
