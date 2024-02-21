package com.example.evento_api.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.evento_api.dto.request.SolicitudRegistroDTO;
import com.example.evento_api.dto.request.SolicitudInicioSesionDTO;
import com.example.evento_api.dto.response.RespuestaAutenticacionJwtDTO;
import com.example.evento_api.servicio.AuthenticationService;



/***
 * Autenticación y Seguridad
 */

@RestController
@RequestMapping("/api/v0/auth")
public class AuthControlador {
 
	@Autowired
    AuthenticationService authenticationService;
	
	
    @PostMapping("/registro")
    public ResponseEntity<RespuestaAutenticacionJwtDTO> registro(@RequestBody SolicitudRegistroDTO request) {
        return ResponseEntity.ok(authenticationService.registro(request));
    }

    @PostMapping("/acceso")
    public ResponseEntity<RespuestaAutenticacionJwtDTO> acceso(@RequestBody SolicitudInicioSesionDTO request) {
        return ResponseEntity.ok(authenticationService.acceso(request));
    }
}
