/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.interivalle.Modelo;

/**
 *
 * @author mary_
 */

import jakarta.persistence.*;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="servicios_detalle")
public class ServiciosDetalle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_detalle")
    private Long idDetalle;

    @Column(name="nombre_servicio")
    private String nombreServicio;

    // Relación con solicitud padre
    @ManyToOne
    @JoinColumn(name="id_solicitud")
    @JsonIgnore //evita ciclo infinito
    private ServiciosACotizar servicio;

    // ===== Getters y Setters =====
    public ServiciosACotizar getServicio() { return servicio; }
    public void setServicio(ServiciosACotizar servicio) { this.servicio = servicio; }

    public String getNombreServicio() { return nombreServicio; }
    public void setNombreServicio(String nombreServicio) { this.nombreServicio = nombreServicio; }
}




