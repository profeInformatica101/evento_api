package com.example.evento_api.dto.request;

import lombok.Data;

@Data
public class SolicitudInicioSesionDTO {
	private String email;
    private String password;
}
