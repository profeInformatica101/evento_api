package com.example.evento_api.entidad;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

	@Data
	@Entity
	@Table(name = "inscripciones")
	public class Inscripcion {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "usuario_id")
	    private Usuario usuario;

	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "evento_id")
	    private Evento evento;

	    // Cualquier campo adicional que necesites
	    private Date fechaInscripcion;
	    private String tipoRol;

}
