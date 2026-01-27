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
import jakarta.validation.constraints.*;
import java.time.LocalDateTime;

/**
 * Clase entidad que representa la tabla 'usuario' en la base de datos.
 * Se utiliza con JPA para mapear los campos y sus relaciones.
 */ 
@Entity
@Table(name="usuario")
public class Usuario {

        // Llave primaria (auto incremental)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    Integer idUsuario;

    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 4, message = "El nombre debe tener mínimo 3 caracteres")
    @Column(name = "nombre_usuario")
    String nombreUsuario;

    
    @NotBlank(message = "El correo es obligatorio")
    @Email(message = "El correo no es válido")
    @Column(name = "correo_usuario")
    String correoUsuario;

    
    
    @Column(name = "contrasena_usuario")
    String contrasenaUsuario;

    @Column(name = "celular_usuario")
    String celularUsuario;

    @Column(name = "nombre_proyecto_usuario")
    String nombreProyectoUsuario;

    @Column(name = "fecha_registro_usuario")
    LocalDateTime fechaRegistroUsuario;
   
    @Column(name = "id_rol")
    Integer idRol = 3;
    
    @PrePersist
    protected void onCreate() {
        this.fechaRegistroUsuario = LocalDateTime.now();
    }
    

     // ------------------ CONSTRUCTORES ------------------
    public Usuario() {
    }
    
    public Usuario(String nombreUsuario, String correoUsuario, String contrasenaUsuario,
                   String celularUsuario, String nombreProyectoUsuario, Integer idRol) {
        this.nombreUsuario = nombreUsuario;
        this.correoUsuario = correoUsuario;
        this.contrasenaUsuario = contrasenaUsuario;
        this.celularUsuario = celularUsuario;
        this.nombreProyectoUsuario = nombreProyectoUsuario;
        this.idRol=idRol;
    }

    //Getters y setters   
 

    public String getNombreUsuario() { return nombreUsuario; }
    public void setNombreUsuario(String nombreUsuario) { 
        this.nombreUsuario = nombreUsuario; }

    public String getCorreoUsuario() { return correoUsuario; }
    
     public void setCorreoUsuario(String correoUsuario) {
        if (correoUsuario.contains("@")) {
            this.correoUsuario = correoUsuario;
        } else {
            System.out.println("Correo inválido");
        }
    }

    public String getContrasenaUsuario() { return contrasenaUsuario; }
    public void setContrasenaUsuario(String contrasenaUsuario) { 
        this.contrasenaUsuario = contrasenaUsuario; }

    public String getCelularUsuario() { return celularUsuario; }
    public void setCelularUsuario(String celularUsuario) { 
        this.celularUsuario = celularUsuario; }

    public String getNombreProyectoUsuario() { return nombreProyectoUsuario; }
    public void setNombreProyectoUsuario(String nombreProyectoUsuario) { 
        this.nombreProyectoUsuario = nombreProyectoUsuario; }

    public LocalDateTime getFechaRegistroUsuario() { return fechaRegistroUsuario; }
    public void setFechaRegistroUsuario(LocalDateTime fechaRegistroUsuario) { 
        this.fechaRegistroUsuario = fechaRegistroUsuario; }
	

}


