package com.example.evento_api.controlador;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/v0/usuarios")
public class UsuariosControlador {
	 // Obtener Detalles del Usuario
    @GetMapping("/{idUsuario}")
    public String obtenerUsuario(@PathVariable String idUsuario) {
        // Aquí iría la lógica para obtener los detalles del usuario
        return "Detalles del usuario con ID: " + idUsuario;
    }

    // Actualizar Perfil del Usuario
    @PutMapping("/{idUsuario}")
    public String actualizarUsuario(@PathVariable String idUsuario, @RequestBody String usuarioInfo) {
        // Aquí iría la lógica para actualizar la información del usuario
        return "Perfil actualizado para el usuario con ID: " + idUsuario;
    }


    // Listar Inscripciones de un Usuario
    @GetMapping("/{idUsuario}/inscripciones")
    public String listarInscripcionesUsuario(@PathVariable String idUsuario) {
        // Aquí iría la lógica para recuperar y mostrar todas las inscripciones del usuario
        return "Listado de inscripciones para el usuario " + idUsuario;
    }
}
