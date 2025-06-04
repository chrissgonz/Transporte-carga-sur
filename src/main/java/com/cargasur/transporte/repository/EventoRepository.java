package com.cargasur.transporte.repository;

import com.cargasur.transporte.model.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Integer> {
    List<Evento> findByOrdenId(Long idOrden);
}
