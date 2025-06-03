package com.cargasur.transporte.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "eventos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_evento;

    @ManyToOne
    @JoinColumn(name = "id_orden", nullable = false)
    private Orden orden;

    @ManyToOne
    @JoinColumn(name = "id_camion", nullable = false)
    private Flota camion;

    @Column(nullable = false)
    private Date fecha_evento;

    @Column(nullable = false, length = 50)
    private String tipo_evento;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    @Column(nullable = false, length = 150)
    private String ubicacion;
}
