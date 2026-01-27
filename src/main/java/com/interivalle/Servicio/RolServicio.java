/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.interivalle.Servicio;

/**
 *
 * @author mary_
 * * Servicio que gestiona la logica de negocio relacionada con los roles.
 */
import com.interivalle.Modelo.Rol;
import com.interivalle.Repositorio.IRolRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class RolServicio {

    @Autowired
    private IRolRepositorio rolRepositorio;
    
    // ------------------ METODOS ------------------
    /**
     * Guarda o actualiza un rol en la base de datos.
     */
    public Rol guardarRol(Rol rol) {
        return rolRepositorio.save(rol);
    }

    /**
     * Devuelve la lista completa de roles.
     */
    public List<Rol> listarRoles() {
        return rolRepositorio.findAll();
    }

    /**
     * Busca un rol por su nombre.
     */
    public Optional<Rol> buscarPorNombre(String nombreRol) {
        return rolRepositorio.findByNombreRol(nombreRol);
    }
}

