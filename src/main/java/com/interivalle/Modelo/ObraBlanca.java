/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.interivalle.Modelo;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.*;

/**
 *
 * @author mary_
 */
@Entity
@Table(name="obra_blanca")
public class ObraBlanca {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_obrablanca")   
    
   private Integer idObraBlanca;
   private String correoUsuario;
   private Double MedidaAreaPrivada;
   private Integer CantidadBanos;
   private Integer CantidadPoyos;
   private Boolean paredDivision;
   private String tipoCielo;
   private Date fechaCotizacion;
   private Integer Id_DetalleCotizacion;
   
   private LocalDate fechaRegistro = LocalDate.now();
}
