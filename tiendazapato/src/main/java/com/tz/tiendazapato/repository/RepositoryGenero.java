package com.tz.tiendazapato.repository;

import org.springframework.data.repository.CrudRepository;

import com.tz.tiendazapato.entidades.Genero;

public interface RepositoryGenero extends CrudRepository<Genero, Long> {
	
	Genero findBynombre(String nombre);

}
