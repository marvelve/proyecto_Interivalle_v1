/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.interivalle.Controlador;

/**
 *
 * @author mary_
 */

import com.interivalle.DTO.ServiciosACotizarDTO;
import com.interivalle.Servicio.ServiciosACotizarServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
//@RequestMapping("/api")
@RequestMapping("/serviciosACotizar")
@CrossOrigin("*")
public class ServiciosACotizarControler {

    @Autowired
    private ServiciosACotizarServicio serviciosACotizarServicio;

    @PostMapping("/crear")
    public ResponseEntity<?> crear(@RequestBody ServiciosACotizarDTO dto){

        try {
        serviciosACotizarServicio.crearSolicitud(dto);
        return ResponseEntity.ok("Solicitud creada correctamente");
        }catch (RuntimeException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
    }
}


