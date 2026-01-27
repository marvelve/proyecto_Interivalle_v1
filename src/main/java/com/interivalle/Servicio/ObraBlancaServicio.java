/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.interivalle.Servicio;

/**
 *
 * @author mary_
 */

import com.interivalle.Modelo.ObraBlanca;
import com.interivalle.Repositorio.IObraBlancaRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ObraBlancaServicio {
     @Autowired
    private IObraBlancaRepositorio repositorio;

    // ------------------ METODOS ------------------
    public ObraBlanca guardar(ObraBlanca obraBlanca) {
        return repositorio.save(obraBlanca);
    }

    public List<ObraBlanca> listarPorCorreo(String correo) {
        return repositorio.findByCorreoUsuario(correo);
    }
    
}
