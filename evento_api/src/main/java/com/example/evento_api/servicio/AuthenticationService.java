package com.example.evento_api.servicio;

import com.example.evento_api.dto.request.SolicitudInicioSesionDTO;
import com.example.evento_api.dto.request.SolicitudRegistroDTO;
import com.example.evento_api.dto.response.RespuestaAutenticacionJwtDTO;

public interface AuthenticationService {

	/** REGISTRO */
	public RespuestaAutenticacionJwtDTO registro(SolicitudRegistroDTO request);
	/** ACCESO */
	public RespuestaAutenticacionJwtDTO acceso(SolicitudInicioSesionDTO request);
}
