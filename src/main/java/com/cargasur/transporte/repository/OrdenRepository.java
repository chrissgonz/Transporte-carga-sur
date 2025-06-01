package com.cargasur.transporte.repository;


import com.cargasur.transporte.model.Orden;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface OrdenRepository extends JpaRepository<Orden,Long> {
    List<Orden> findByClienteId(Long clienteId);
}
