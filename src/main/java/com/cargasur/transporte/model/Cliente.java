package com.cargasur.transporte.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "clientes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;


    @Column(nullable = false, length = 100, unique = false)
    private String nombres;

    @Column(nullable = false, length = 100, unique = false)
    private String apellidos;

    @Column(nullable = false, length = 100, unique = true)
    private String email;

    @Column(nullable = false, unique = false)
    private Date fechaNacimiento;









}
