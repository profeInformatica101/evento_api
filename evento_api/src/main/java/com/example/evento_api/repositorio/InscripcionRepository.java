package com.example.evento_api.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.evento_api.entidad.Inscripcion;

public interface InscripcionRepository extends JpaRepository<Inscripcion, Long> {
	
}
