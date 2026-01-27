/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.interivalle.Controlador;

/**
 *
 * @author mary_
 */

import com.interivalle.Modelo.ServiciosACotizar;
import com.interivalle.Modelo.ServiciosDetalle;
import com.interivalle.Modelo.Usuario;
import com.interivalle.Servicio.ServiciosACotizarServicio;
import com.interivalle.Servicio.UsuarioServicio;
import java.time.LocalDate;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/servicios")
@CrossOrigin("*")

public class ServiciosACotizarControler {

    @Autowired
    private ServiciosACotizarServicio servicio;
    @Autowired
    private UsuarioServicio usuarioServicio;


    @PostMapping("/guardar")
public ServiciosACotizar guardar(@RequestBody ServiciosACotizar solicitud) {

    // Obtener el correo que llega desde el frontend
    String correo = solicitud.getUsuario().getCorreoUsuario();

    // Buscar usuario real en la base de datos
    Optional<Usuario> u = usuarioServicio.buscarPorCorreo(correo);

    Usuario usuario = u.orElseThrow(() ->
        new RuntimeException("Usuario no encontrado")
    );

    // Asignar usuario real a la solicitud
    solicitud.setUsuario(usuario);

    // Fecha automática
    solicitud.setFechaSolicitud(LocalDate.now());

    // Relación inversa en detalles
    if(solicitud.getDetalles() != null){
        for(ServiciosDetalle d : solicitud.getDetalles()){
            d.setServicio(solicitud);
        }
    }

    // Guardar todo en cascada
    return servicio.guardarSolicitud(solicitud);
}


  
}

