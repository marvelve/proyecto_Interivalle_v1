/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.interivalle.Modelo;

/**
 *
 * @author mary_
 * Entidad Usuario (TABLA)
 * Clase entidad que representa la tabla 'usuario' en la base de datos.
 * Se utiliza con JPA para mapear los campos y sus relaciones.
 */

import jakarta.persistence.*;
import java.time.LocalDateTime;

/**
 * Clase entidad que representa la tabla 'usuario' en la base de datos.
 * Se utiliza con JPA para mapear los campos y sus relaciones.
 */
@Entity
@Table(name = "usuario")
public class Usuario {

    // Llave primaria (auto incremental)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idUsuario;

    @Column(nullable = false)
    String nombreUsuario;
    
    @Column(nullable = false, unique = true)
    String correoUsuario;

    @Column(nullable = false)
    String contrasenaUsuario;

    LocalDateTime fechaRegistroUsuario = LocalDateTime.now();
    String celularUsuario;
    String nombreProyectoUsuario;
	
    @ManyToOne
    Integer idRol;
    // Relación con la tabla Rol
    

    // ------------------ CONSTRUCTORES ------------------
    public Usuario() {
    }

    public Usuario(String nombreUsuario, String correoUsuario, String contrasenaUsuario,String celularUsuario, String nombreProyectoUsuario, Integer idRol) {
        this.nombreUsuario = nombreUsuario;
        this.correoUsuario = correoUsuario;
        this.contrasenaUsuario = contrasenaUsuario;
        this.celularUsuario = celularUsuario;
        this.nombreProyectoUsuario = nombreProyectoUsuario;
        this.idRol = idRol;
        this.fechaRegistroUsuario = LocalDateTime.now();
    }

    // ------------------ GETTERS Y SETTERS ------------------
    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getCorreoUsuario() {
        return correoUsuario;
    }

    public void setCorreoUsuario(String correoUsuario) {
        this.correoUsuario = correoUsuario;
    }

    public String getContrasenaUsuario() {
        return contrasenaUsuario;
    }

    public void setContrasenaUsuario(String contrasenaUsuario) {
        this.contrasenaUsuario = contrasenaUsuario;
    }

    public LocalDateTime getFechaRegistroUsuario() {
        return fechaRegistroUsuario;
    }

    public void setFechaRegistroUsuario(LocalDateTime fechaRegistroUsuario) {
        this.fechaRegistroUsuario = fechaRegistroUsuario;
    }

    public String getCelularUsuario() {
        return celularUsuario;
    }

    public void setCelularUsuario(String celularUsuario) {
        this.celularUsuario = celularUsuario;
    }

    public String getNombreProyectoUsuario() {
        return nombreProyectoUsuario;
    }

    public void setNombreProyectoUsuario(String nombreProyectoUsuario) {
        this.nombreProyectoUsuario = nombreProyectoUsuario;
    }

    public Integer getRol() {
        return idRol;
    }

    public void setRol(Integer idRol) {
        this.idRol = idRol;
    }
}


