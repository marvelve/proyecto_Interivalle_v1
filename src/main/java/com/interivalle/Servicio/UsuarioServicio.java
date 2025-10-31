/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.interivalle.Servicio;
/**
 *
 * @author mary_
 * UsuarioServicio.java es la Capa de negocio (validaciones, reglas)
 */

import com.interivalle.Modelo.Usuario;
import com.interivalle.Repositorio.IUsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

/**
 * Capa de negocio encargada de la logica relacionada con usuarios.
 * Interactua con la capa de persistencia (Repositorio) y el Controlador.
 */
@Service
public class UsuarioServicio {

    @Autowired
    private IUsuarioRepositorio usuarioRepositorio;

    // ------------------ METODOS ------------------

    // Registrar un nuevo usuario
    public Usuario registrarUsuario(Usuario usuario) {
        if (usuarioRepositorio.existsByCorreoUsuario(usuario.getCorreoUsuario())) {
            throw new RuntimeException("El correo ya esta registrado");
        }
        return usuarioRepositorio.save(usuario);
    }

    // Listar todos los usuarios
    public List<Usuario> listarUsuarios() {
        return usuarioRepositorio.findAll();
    }

    // Buscar usuario por correo
    public Optional<Usuario> buscarPorCorreo(String correoUsuario) {
        return usuarioRepositorio.findByCorreoUsuario(correoUsuario);
    }

    // Eliminar usuario por ID
    public void eliminarUsuario(String correoUsuario) {
        usuarioRepositorio.deleteById(correoUsuario);
    }
}
