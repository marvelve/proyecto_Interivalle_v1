/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.interivalle.Controlador;
/**
 * @author mary_
 * Capa de presentación (controlador REST)
 * Controlador REST que gestiona las solicitudes HTTP relacionadas con usuarios.
 * Aquí se definen los endpoints que se comunicarán con el frontend.
 */
import com.interivalle.Modelo.Usuario;
import com.interivalle.Servicio.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


@RestController
@RequestMapping("/api/usuarios") // URL base para acceder al controlador

public class UsuarioControler {

    @Autowired
    private UsuarioServicio usuarioServicio;

    // ------------------ ENDPOINTS ------------------

    // Registrar usuario (POST)
    @PostMapping("/guardar")
   public ResponseEntity<?> guardarUsuario(@RequestBody Usuario usuario) {
    try {
        Usuario nuevo = usuarioServicio.guardarUsuario(usuario);
        return ResponseEntity.ok(nuevo);
    } catch (IllegalArgumentException e) {
        // Este es el mensaje que verás en el navegador
        return ResponseEntity.badRequest().body(e.getMessage());
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno del servidor");
    }
}
   
@PostMapping("/login")
public ResponseEntity<?> loginUsuario(@RequestBody Usuario usuario) {

    Usuario usuarioEncontrado = usuarioServicio.validarLogin(
            usuario.getCorreoUsuario(), usuario.getContrasenaUsuario()
    );

    if (usuarioEncontrado != null) {
        return ResponseEntity.ok(usuarioEncontrado);
    } else {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(Map.of("mensaje", "Correo o contraseña incorrectos"));
    }
}

    
        // Buscar usuario por correo (GET)
    @GetMapping("/buscar/{correo_usuario}")
    public Optional<Usuario> buscarUsuarioPorCorreo(@PathVariable("correo_usuario") String correoUsuario) {
        return usuarioServicio.buscarPorCorreo(correoUsuario);
    }

    // Listar todos los usuarios (GET)
    @GetMapping
    public List<Usuario> listarUsuarios() {
        return usuarioServicio.listarUsuarios();
    }

    // Eliminar usuario por ID (DELETE)
    @DeleteMapping("/eliminar/{correo_usuario}")
    public String eliminarUsuario(@PathVariable String correoUsuario) {
        usuarioServicio.eliminarUsuario(correoUsuario);
        return "Usuario eliminado correctamente";
    }
}

