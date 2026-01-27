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

public interface IServiciosDetalleRepositorio extends JpaRepository<ServiciosDetalle, Long> {
}

