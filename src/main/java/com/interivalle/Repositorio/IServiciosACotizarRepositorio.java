package com.interivalle.Repositorio;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

/**
 *
 * @author mary_
 */

import com.interivalle.Modelo.ServiciosACotizar;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface IServiciosACotizarRepositorio extends JpaRepository<ServiciosACotizar, Long> {

    List<ServiciosACotizar> findByUsuario_CorreoUsuario(String correo);
}
    
