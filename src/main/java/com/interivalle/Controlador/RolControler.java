/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.interivalle.Controlador;

/**
 ** @author mary_
 * Controlador REST para manejar los endpoints del modulo Rol.
 */

import com.interivalle.Modelo.Rol;
import com.interivalle.Servicio.RolServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/roles")
@CrossOrigin(origins = "*")
public class RolControler {

    @Autowired
    private RolServicio rolServicio;

    /**
     * Endpoint para registrar un nuevo rol.
     * POST /api/roles/registrar
     */
    @PostMapping("/registrar")
    public Rol guardarRol(@RequestBody Rol rol) {
        return rolServicio.guardarRol(rol);
    }

    /**
     * Endpoint para listar todos los roles.
     * GET /api/roles/listar
     */
    @GetMapping("/listar")
    public List<Rol> listarRoles() {
        return rolServicio.listarRoles();
    }
}

