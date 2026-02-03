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


@Entity
@Table(name="servicios_detalle")
public class ServiciosDetalle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDetalle;

    @ManyToOne
    @JoinColumn(name = "id_servicios_a_cotizar", nullable = false)
    private ServiciosACotizar serviciosACotizar;

    @ManyToOne
    @JoinColumn(name = "id_servicio", nullable = false)
    private Servicios servicio;

    private String estado; // GENERADO | PENDIENTE


    // ===== Getters y Setters =====
    
      public Long getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(Long idDetalle) {
        this.idDetalle = idDetalle;
    }

    public ServiciosACotizar getServiciosACotizar() {
        return serviciosACotizar;
    }

    public void setServiciosACotizar(ServiciosACotizar serviciosACotizar) {
        this.serviciosACotizar = serviciosACotizar;
    }

    public Servicios getServicio() {
        return servicio;
    }

    public void setServicio(Servicios servicio) {
        this.servicio = servicio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
     
}

