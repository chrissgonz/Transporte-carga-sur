package com.cargasur.transporte.repository;

import com.cargasur.transporte.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
