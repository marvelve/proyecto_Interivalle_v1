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
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "servicios_acotizar")
public class ServiciosACotizar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idServiciosACotizar;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;
    
    @Column(name = "nombre_proyecto_usuario", nullable = false)
    private String nombreProyectoUsuario;
    
    private LocalDate fechaSolicitud;

    private String tipoSolicitud; // COTIZACION | VISITA

    private String estado; // GENERADO | PENDIENTE

    // Relación: Una solicitud tiene muchos detalles
    @OneToMany(mappedBy = "serviciosACotizar", cascade = CascadeType.ALL)
    private List<ServiciosDetalle> serviciosDetalle;

    @OneToOne(mappedBy = "serviciosACotizar", cascade = CascadeType.ALL)
    private VisitaTecnica visitaTecnica;

    // getters y setters

    public Long getIdServiciosACotizar() {
        return idServiciosACotizar;
    }

    public void setIdServiciosACotizar(Long idServiciosACotizar) {
        this.idServiciosACotizar = idServiciosACotizar;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public String getNombreProyectoUsuario() {
        return nombreProyectoUsuario;
    }

    public void setNombreProyectoUsuario(String nombreProyectoUsuario) {
        this.nombreProyectoUsuario = nombreProyectoUsuario;
    }

    public LocalDate getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(LocalDate fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public String getTipoSolicitud() {
        return tipoSolicitud;
    }

    public void setTipoSolicitud(String tipoSolicitud) {
        this.tipoSolicitud = tipoSolicitud;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<ServiciosDetalle> getServiciosDetalle() {
        return serviciosDetalle;
    }

    public void setServiciosDetalle(List<ServiciosDetalle> serviciosDetalle) {
        this.serviciosDetalle = serviciosDetalle;
    }

    public VisitaTecnica getVisitaTecnica() {
        return visitaTecnica;
    }

    public void setVisitaTecnica(VisitaTecnica visitaTecnica) {
        this.visitaTecnica = visitaTecnica;
    }
    
 
}

    


