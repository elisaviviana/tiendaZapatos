package com.tz.tiendazapato.servicios;

import com.tz.tiendazapato.entidades.Usuario;

public interface ServiceUsuario {
	
	Usuario buscarUsuario(Long id) throws Exception;
	
	Usuario buscarUsuarioPorNombre(String nombre);
	
	Iterable<Usuario>  buscarAllUsuario();
	
	boolean editarUsuario(Usuario user) throws Exception;
	
	boolean agregar(Usuario user) throws Exception ;
	
	boolean eliminar(Usuario user) throws Exception ;

}
