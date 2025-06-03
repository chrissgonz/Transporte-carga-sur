package com.cargasur.transporte.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "flota")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Flota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_camion;

    @Column(nullable = false, length = 20, unique = true)
    private String patente;

    @Column(nullable = false, length = 50)
    private String modelo;

    @Column(nullable = false, length = 50)
    private String marca;

    @Column(nullable = false)
    private Double capacidad_carga;

    @Column(nullable = false, length = 30)
    private String estado_operativo;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date ultima_mantencion;
}
