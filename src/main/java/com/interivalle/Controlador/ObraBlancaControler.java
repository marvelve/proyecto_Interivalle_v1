/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.interivalle.Controlador;

/**
 *
 * @author mary_
 */
import com.interivalle.Modelo.ObraBlanca;
import com.interivalle.Servicio.ObraBlancaServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/obrablanca")
@CrossOrigin("*") // Permite peticiones desde tus archivos HTML
public class ObraBlancaControler {

    @Autowired
    private ObraBlancaServicio obraBlancaServicio;

    // 🔹 Guardar una nueva cotización
    @PostMapping("/guardar")
    public ObraBlanca guardar(@RequestBody ObraBlanca obraBlanca) {
        return obraBlancaServicio.guardar(obraBlanca);
    }

    // 🔹 Listar cotizaciones por correo de usuario
    @GetMapping("/listar/{correo}")
    public List<ObraBlanca> listarPorCorreo(@PathVariable String correo) {
        return obraBlancaServicio.listarPorCorreo(correo);
    }
}