/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.interivalle.Servicio;

import com.interivalle.DTO.ServiciosACotizarDTO;
import com.interivalle.Modelo.*;
import com.interivalle.Repositorio.*;
import jakarta.transaction.Transactional;
import java.time.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author mary_
 */


@Service
public class ServiciosACotizarServicio {
    
    @Autowired
    private IUsuarioRepositorio usuarioRepo;

    @Autowired
    private IServiciosACotizarRepositorio repo;

    @Autowired
    private IServiciosRepositorio serviciosRepo;

    @Autowired
    private IServiciosDetalleRepositorio detalleRepo;

    @Autowired
    private IVisitaTecnicaRepositorio visitaRepo;

@Transactional
public void crearSolicitud(ServiciosACotizarDTO dto) {

    //VALIDAR DUPLICADOS (ANTES DE GUARDAR)
    for (Long idServicio : dto.getServicios()) {
        long existe = detalleRepo.existeServicioEnProyecto(
                dto.getCorreoUsuario(),
                dto.getNombreProyectoUsuario(),
                idServicio
        );

        if (existe > 0) {
            throw new RuntimeException(
                "La cotización ya existe para uno de los servicios seleccionado para este proyecto"
            );
        }
    }

    // OBTENER USUARIO
    Usuario usuario = usuarioRepo
            .findByCorreoUsuario(dto.getCorreoUsuario())
            .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

    //CREAR CABECERA (UNA SOLA VEZ)
    ServiciosACotizar solicitud = new ServiciosACotizar();
    solicitud.setUsuario(usuario);
    solicitud.setFechaSolicitud(LocalDate.now());
    solicitud.setNombreProyectoUsuario(dto.getNombreProyectoUsuario());
    solicitud.setTipoSolicitud(dto.getTipoSolicitud());
    solicitud.setEstado("GENERADO");

    repo.save(solicitud);

    //SI ES COTIZACIÓN → GUARDAR DETALLES
    if ("COTIZACION".equals(dto.getTipoSolicitud())) {

        for (Long idServicio : dto.getServicios()) {

            Servicios servicio = serviciosRepo.findById(idServicio)
                    .orElseThrow(() -> new RuntimeException("Servicio no encontrado"));

            ServiciosDetalle det = new ServiciosDetalle();
            det.setServiciosACotizar(solicitud);
            det.setServicio(servicio);
            det.setEstado("GENERADO");

            detalleRepo.save(det);
        }
    }

    // SI ES VISITA → GUARDAR VISITA (UNA SOLA)
    if ("VISITA".equals(dto.getTipoSolicitud())) {

        VisitaTecnica visita = new VisitaTecnica();
        visita.setServiciosACotizar(solicitud);
        visita.setFechaVisita(dto.getFecha());
        visita.setHora(dto.getHora());
        visita.setDireccion(dto.getDireccion());
        visita.setEstado("PENDIENTE");

        visitaRepo.save(visita);
    }
}

}




