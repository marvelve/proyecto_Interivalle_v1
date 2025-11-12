/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package com.interivalle.Repositorio;

/**
 *
 * @author mary_
 * Repositorio que permite realizar operaciones CRUD sobre la tabla Rol.
 */
import com.interivalle.Modelo.Rol;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IRolRepositorio extends JpaRepository<Rol, String> {
    Optional<Rol> findByNombreRol(String nombreRol);
}
