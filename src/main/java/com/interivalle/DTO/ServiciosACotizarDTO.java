/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.interivalle.DTO;

/**
 *
 * @author mary_
 */
import com.interivalle.Modelo.Usuario;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class ServiciosACotizarDTO {

    private Long idUsuario;
    private String tipoSolicitud; // COTIZACION | VISITA
    private Usuario usuario;
    private String correoUsuario;
    private String nombreProyectoUsuario;
    // Para cotización
    private List<Long> servicios;

    // Para visita técnica
    private LocalDate fecha;
    private LocalTime hora;
    private String direccion;

    // getters y setters
    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }
    
     public Usuario getUsuario() {
        return usuario;
    }

      public String getCorreoUsuario() {
        return correoUsuario;
    }

    public void setCorreoUsuario(String correoUsuario) {
        this.correoUsuario = correoUsuario;
    }
    public String getTipoSolicitud() {
        return tipoSolicitud;
    }

    public void setTipoSolicitud(String tipoSolicitud) {
        this.tipoSolicitud = tipoSolicitud;
    }
    
    public String getNombreProyectoUsuario() {
        return nombreProyectoUsuario;
    }

    public void setNombreProyectoUsuario(String nombreProyectoUsuario) {
        this.nombreProyectoUsuario = nombreProyectoUsuario;
    }
    
    public List<Long> getServicios() {
        return servicios;
    }

    public void setServicios(List<Long> servicios) {
        this.servicios = servicios;
    }


    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
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
}
