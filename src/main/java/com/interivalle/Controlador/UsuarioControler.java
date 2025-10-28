/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.interivalle.Controlador;

/**
 *
 * @author mary_
 * Capa de presentación (controlador REST)
 * Controlador REST que gestiona las solicitudes HTTP relacionadas con usuarios.
 * Aquí se definen los endpoints que se comunicarán con el frontend.
 */
import com.interivalle.Modelo.Usuario;
import com.interivalle.Servicio.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/usuarios") // URL base para acceder al controlador
@CrossOrigin(origins = "http://localhost:3000") // Permite conexión con React o Postman
public class UsuarioControler {

    @Autowired
    private UsuarioServicio usuarioServicio;

    // ------------------ ENDPOINTS ------------------

    // Registrar usuario (POST)
    @PostMapping("/registrar")
    public Usuario registrarUsuario(@RequestBody Usuario usuario) {
        return usuarioServicio.registrarUsuario(usuario);
    }

    // Listar todos los usuarios (GET)
    @GetMapping("/listar")
    public List<Usuario> listarUsuarios() {
        return usuarioServicio.listarUsuarios();
    }

    // Buscar usuario por correo (GET)
    @GetMapping("/buscar/{correo}")
    public Optional<Usuario> buscarUsuarioPorCorreo(@PathVariable String correo) {
        return usuarioServicio.buscarPorCorreo(correo);
    }

    // Eliminar usuario por ID (DELETE)
    @DeleteMapping("/eliminar/{id}")
    public String eliminarUsuario(@PathVariable String correo) {
        usuarioServicio.eliminarUsuario(correo);
        return "Usuario eliminado correctamente";
    }
}

