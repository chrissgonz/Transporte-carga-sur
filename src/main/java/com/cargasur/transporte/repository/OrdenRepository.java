package com.cargasur.transporte.repository;


import com.cargasur.transporte.model.Orden;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdenRepository extends JpaRepository<Orden,Long> {
}
