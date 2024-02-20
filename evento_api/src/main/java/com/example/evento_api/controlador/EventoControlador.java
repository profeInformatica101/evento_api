package com.example.evento_api.controlador;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v0/eventos")
public class EventoControlador {

    // Crear Evento
    @PostMapping
    public String crearEvento(@RequestBody String eventoInfo) {
        // Lógica para crear un nuevo evento
        return "Evento creado con la información: " + eventoInfo;
    }

    // Listar Todos los Eventos
    @GetMapping
    public String listarEventos() {
        // Lógica para listar todos los eventos
        return "Lista de todos los eventos";
    }

    // Obtener Detalles de un Evento
    @GetMapping("/{idEvento}")
    public String obtenerEvento(@PathVariable String idEvento) {
        // Lógica para obtener los detalles de un evento específico
        return "Detalles del evento con ID: " + idEvento;
    }

    // Actualizar Evento
    @PutMapping("/{idEvento}")
    public String actualizarEvento(@PathVariable String idEvento, @RequestBody String eventoInfo) {
        // Lógica para actualizar un evento existente
        return "Evento con ID " + idEvento + " actualizado con la información: " + eventoInfo;
    }

    // Eliminar Evento
    @DeleteMapping("/{idEvento}")
    public String eliminarEvento(@PathVariable String idEvento) {
        // Lógica para eliminar un evento
        return "Evento con ID " + idEvento + " eliminado";
    }

    @PostMapping("/{idEvento}/inscripciones")
    public String inscribirseEvento(@PathVariable String idEvento, @RequestParam("tipo") String tipoRol) {
        // Aquí deberías implementar la lógica para validar el rol
        boolean esRolValido = validarRol(tipoRol);
        if (!esRolValido) {
            return "Rol no válido. Por favor, elige un rol permitido para la inscripción.";
        }

        // Aquí iría la lógica para procesar la inscripción del usuario en el evento con el rol específico
        // Por ejemplo, añadir una entrada en la base de datos para la inscripción

        return "Inscripción realizada con éxito en el evento con ID " + idEvento + " como " + tipoRol;
    }

    // Método para validar si el tipo de rol es permitido
    private boolean validarRol(String tipoRol) {
        // Aquí deberías tener una lista o un conjunto de roles permitidos
        // y verificar si el tipoRol proporcionado está en esa lista
        // Por ejemplo:
        // List<String> rolesPermitidos = Arrays.asList("fotografo", "participante", "organizador");
        // return rolesPermitidos.contains(tipoRol);

        // Por simplicidad, supongamos que solo "fotografo" es un rol válido
        return "fotografo".equals(tipoRol);
    }
}
