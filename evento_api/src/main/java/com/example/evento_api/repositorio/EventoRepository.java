package com.example.evento_api.repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.evento_api.entidad.Evento;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long>{
	Optional<Evento> findByNombre(String nombre);
}
