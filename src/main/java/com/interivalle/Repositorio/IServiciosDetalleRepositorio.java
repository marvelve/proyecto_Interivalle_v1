/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.interivalle.Repositorio;

/**
 *
 * @author mary_
 */

import org.springframework.data.jpa.repository.JpaRepository;
import com.interivalle.Modelo.ServiciosDetalle;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IServiciosDetalleRepositorio extends JpaRepository<ServiciosDetalle, Long> {
    
   @Query("""
   SELECT COUNT(sd) 
   FROM ServiciosDetalle sd
   JOIN sd.serviciosACotizar sc
   WHERE sc.usuario.correoUsuario = :correoUsuario
     AND sc.nombreProyectoUsuario = :nombreProyectoUsuario
     AND sd.servicio.idServicio = :idServicio
""")
long existeServicioEnProyecto(
        @Param("correoUsuario") String correo,
        @Param("nombreProyectoUsuario") String nombreProyectoUsuario,
        @Param("idServicio") Long idServicio
);
}



