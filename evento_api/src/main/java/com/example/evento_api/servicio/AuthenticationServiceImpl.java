package com.example.evento_api.servicio;

import com.example.evento_api.dto.request.SolicitudRegistroDTO;

import org.springframework.stereotype.Service;

import com.example.evento_api.dto.request.SolicitudInicioSesionDTO;
import com.example.evento_api.dto.response.RespuestaAutenticacionJwtDTO;

import lombok.Builder;
@Builder
@Service
public class AuthenticationServiceImpl implements AuthenticationService {
	
	
	@Override
	public RespuestaAutenticacionJwtDTO registro(SolicitudRegistroDTO request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RespuestaAutenticacionJwtDTO acceso(SolicitudInicioSesionDTO request) {
		// TODO Auto-generated method stub
		return null;
	}
	




}
