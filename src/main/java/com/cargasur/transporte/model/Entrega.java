/*package com.cargasur.transporte.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

public class Entrega {
    @Entity
    @Table(name = "facturacion")
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Facturacion {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id_factura;

        @ManyToOne
        @JoinColumn(name = "id_orden", nullable = false)
        private Orden orden;

        @ManyToOne
        @JoinColumn(name = "id_usuario", nullable = false)
        private Usuario usuario;

        @Column(nullable = false)
        private BigDecimal monto_total;

        @Column(nullable = false)
        private Date fecha_emision;

        @Column(nullable = false, length = 20)
        private String estado_pago;
    }
}
*/