package com.cargasur.transporte.service;

import com.cargasur.transporte.model.Usuario;
import com.cargasur.transporte.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> getAll() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> getById(Long id) {
        return usuarioRepository.findById(id);
    }

    public Usuario create(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Optional<Usuario> update(Long id, Usuario usuario) {
        return usuarioRepository.findById(id).map(u -> {
            u.setCorreo(usuario.getCorreo());
            u.setClave(usuario.getClave());
            u.setRol(usuario.getRol());
            return usuarioRepository.save(u);
        });
    }

    public boolean delete(Long id) {
        return usuarioRepository.findById(id).map(usuario -> {
            usuarioRepository.delete(usuario);
            return true;
        }).orElse(false);
    }

    public Optional<Usuario> login(String correo, String clave) {
        return usuarioRepository.findByCorreoAndClave(correo, clave);
    }
}
