/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.interivalle.Repositorio;

/**
 *
 * @author mary_
 */

import com.interivalle.Modelo.ObraBlanca;
import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IObraBlancaRepositorio extends JpaRepository<ObraBlanca, Integer> {

   List<ObraBlanca> findByCorreoUsuario(String correoUsuario);
    
}
