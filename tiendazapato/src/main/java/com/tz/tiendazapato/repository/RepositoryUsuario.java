package com.tz.tiendazapato.repository;

import org.springframework.data.repository.CrudRepository;

import com.tz.tiendazapato.entidades.Usuario;

public interface RepositoryUsuario extends CrudRepository<Usuario, Long> {
	
	Usuario findBynombre(String nombre);


}
