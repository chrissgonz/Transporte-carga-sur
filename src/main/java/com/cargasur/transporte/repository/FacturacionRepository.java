package com.cargasur.transporte.repository;

import com.cargasur.transporte.model.Facturacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturacionRepository extends JpaRepository<Facturacion, Integer> {
}
