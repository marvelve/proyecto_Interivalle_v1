/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.interivalle.Servicio;

/**
 *
 * @author mary_
 */
import com.interivalle.Modelo.*;
import com.interivalle.Repositorio.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiciosACotizarServicio {

    @Autowired
    private IServiciosACotizarRepositorio repo;
    @Autowired
    private IServiciosDetalleRepositorio repoDetalle;
    
// ------------------ METODOS ------------------

    public ServiciosACotizar guardarSolicitud(ServiciosACotizar s){
       return repo.save(s);
    }

    public void guardarDetalle(ServiciosDetalle d){
       repoDetalle.save(d);
    }

} 


