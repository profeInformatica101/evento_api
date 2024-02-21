package com.example.evento_api;


import java.time.*;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.example.evento_api.entidad.Evento;
import com.example.evento_api.entidad.Inscripcion;
import com.example.evento_api.entidad.Usuario;
import com.example.evento_api.repositorio.EventoRepository;
import com.example.evento_api.repositorio.InscripcionRepository;
import com.example.evento_api.repositorio.UsuarioRepository;

@Component
public class InitializationData implements CommandLineRunner{
	@Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private EventoRepository eventoRepository;

    @Autowired
    private InscripcionRepository inscripcionRepository;
    

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        // Usuarios
        Usuario user1 = new Usuario();
        user1.setEmail("john.doe@example.com");
        user1.setPassword(passwordEncoder.encode("password")); // Codifica la contraseña
        usuarioRepository.save(user1);

        Usuario user2 = new Usuario();
        user2.setEmail("jane.smith@example.com");
        user2.setPassword(passwordEncoder.encode("password")); // Codifica la contraseña
        usuarioRepository.save(user2);
        // Eventos
        Evento event1 = new Evento();
        event1.setNombre("Evento de Tecnología");
        // Establece la fecha del evento para mañana usando Calendar
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        event1.setFecha(calendar.getTime());
        event1.setUbicacion("Ciudad Tecnológica");
        eventoRepository.save(event1);

        Evento event2 = new Evento();
        event2.setNombre("Evento de Networking");
        // Establece la fecha del evento para mañana usando Calendar
        calendar.add(Calendar.DAY_OF_YEAR, 1); // Asegúrate de restablecer la fecha si es necesario
        event2.setFecha(calendar.getTime());
        event2.setUbicacion("Centro de Convenciones");
        eventoRepository.save(event2);


        // Inscripciones
        Inscripcion inscripcion = new Inscripcion();
        inscripcion.setUsuario(user1);
        inscripcion.setEvento(event1);
        inscripcion.setFechaInscripcion(new Date()); // Usa la fecha actual para la inscripción
        inscripcionRepository.save(inscripcion);
    }
	
}