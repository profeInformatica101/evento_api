package com.example.evento_api.dto.request;

import lombok.Data;

@Data
public class SolicitudRegistroDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
