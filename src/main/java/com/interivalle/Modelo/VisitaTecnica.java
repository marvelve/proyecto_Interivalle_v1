/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.interivalle.Modelo;

import jakarta.persistence.*;
import java.time.*;

/**
 *
 * @author mary_
 */

@Entity
@Table(name="visita_tecnica")
public class VisitaTecnica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVisita;

    @OneToOne
    @JoinColumn(name = "id_servicios_a_cotizar", nullable = false)
    private ServiciosACotizar serviciosACotizar;

    private LocalDate fechaVisita;
    private LocalTime hora;
    private String direccion;
    private String estado; // PENDIENTE | ATENDIDO

    public Long getIdVisita() {
        return idVisita;
    }

    public void setIdVisita(Long idVisita) {
        this.idVisita = idVisita;
    }

    public ServiciosACotizar getServiciosACotizar() {
        return serviciosACotizar;
    }

    public void setServiciosACotizar(ServiciosACotizar serviciosACotizar) {
        this.serviciosACotizar = serviciosACotizar;
    }

    public LocalDate getFechaVisita() {
        return fechaVisita;
    }

    public void setFechaVisita(LocalDate fechaVisita) {
        this.fechaVisita = fechaVisita;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    } 
}

