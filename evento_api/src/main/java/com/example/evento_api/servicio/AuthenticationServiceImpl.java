package com.example.evento_api.servicio;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import com.example.evento_api.dto.request.SolicitudInicioSesionDTO;
import com.example.evento_api.dto.request.SolicitudRegistroDTO;
import com.example.evento_api.dto.response.RespuestaAutenticacionJwtDTO;
import com.example.evento_api.entidad.Usuario;
import com.example.evento_api.entidad.enumerado.Role;
import com.example.evento_api.repositorio.UsuarioRepository;

import lombok.Builder;

@Builder
@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private UsuarioRepository userRepository; // Asegúrate de que UserRepository esté inyectado correctamente
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
	
    
    // Constructor para inyección de dependencias (si usas Spring)
    public AuthenticationServiceImpl(UsuarioRepository userRepository,
                                     PasswordEncoder passwordEncoder,
                                     JwtService jwtService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }
	@Override
	public RespuestaAutenticacionJwtDTO registro(SolicitudRegistroDTO request) {
		  if(userRepository.existsByEmail(request.getEmail())) {
	            throw new IllegalArgumentException("Email already in use.");
	        }
	        // Corrige la forma de construir el objeto 'User'
	        Usuario user = new Usuario();

	        user.setEmail(request.getEmail());
	        user.setPassword(passwordEncoder.encode(request.getPassword()));
	        user.getRoles().add(Role.ROLE_USER); // Asegúrate de que Role.USER esté definido correctamente
	        userRepository.save(user);
	        String jwt = jwtService.generateToken(user);
	        return RespuestaAutenticacionJwtDTO.builder().token(jwt).build();
	}

	@Override
	public RespuestaAutenticacionJwtDTO acceso(SolicitudInicioSesionDTO request) {
		 Usuario user = userRepository.findByEmail(request.getEmail())
	                .orElseThrow(() -> new IllegalArgumentException("Invalid email or password."));
	        String jwt = jwtService.generateToken(user);
	        return RespuestaAutenticacionJwtDTO.builder().token(jwt).build();
	}
	




}
