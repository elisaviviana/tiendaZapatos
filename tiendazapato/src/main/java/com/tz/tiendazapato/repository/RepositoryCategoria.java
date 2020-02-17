package com.tz.tiendazapato.repository;

import org.springframework.data.repository.CrudRepository;

import com.tz.tiendazapato.entidades.Categoria;

public interface RepositoryCategoria extends CrudRepository<Categoria, Long> {

	Categoria findBynombre(String nombre);

}
