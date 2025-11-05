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
import java.time.LocalDate;
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
    public Usuario guardarUsuario(Usuario usuario) {
       // Verificar si el correo ya existe
        Optional<Usuario> existente = usuarioRepositorio.findByCorreoUsuario(usuario.getCorreoUsuario());
        if (existente.isPresent()) {
            throw new IllegalArgumentException("El correo ya esta registrado");
        }
        return usuarioRepositorio.save(usuario);
    }
    
    // Buscar usuario por correo
    public Optional<Usuario> buscarPorCorreo(String correoUsuario) {
        return usuarioRepositorio.findByCorreoUsuario(correoUsuario);
    }
    
    public Usuario validarLogin(String correo, String contrasena) {
    Optional<Usuario> usuario = usuarioRepositorio.findByCorreoUsuario(correo);

    if (usuario.isPresent() && usuario.get().getContrasenaUsuario().equals(contrasena)) {
        return usuario.get();
    }
    return null; // Si no existe o la contraseña no coincide
}

     

    // Listar todos los usuarios
    public List<Usuario> listarUsuarios() {
        return usuarioRepositorio.findAll();
    }


    // Eliminar usuario por ID
    public void eliminarUsuario(String correoUsuario) {
        usuarioRepositorio.deleteById(correoUsuario);
    }
}
