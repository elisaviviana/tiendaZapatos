package com.tz.tiendazapato.repository;

import org.springframework.data.repository.CrudRepository;

import com.tz.tiendazapato.entidades.Marca;

public interface RepositoryMarca extends CrudRepository<Marca, Long> {
	
	Marca findBynombre(String nombre);

}
