package com.cargasur.transporte.repository;

import com.cargasur.transporte.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByCorreoAndClave(String correo, String clave);
}