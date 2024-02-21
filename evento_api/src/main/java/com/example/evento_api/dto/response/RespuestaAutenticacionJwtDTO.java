package com.example.evento_api.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RespuestaAutenticacionJwtDTO {
	 private String token;
}
