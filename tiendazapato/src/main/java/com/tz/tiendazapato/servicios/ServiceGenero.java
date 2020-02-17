package com.tz.tiendazapato.servicios;

import com.tz.tiendazapato.entidades.Genero;

public interface ServiceGenero {
	
	Genero buscarGenero(Long id) throws Exception;
	
	Genero buscarGeneroPorNombre(String nombre);
	
	Iterable<Genero>  buscarAllGenero();
	
	boolean editarGenero(Genero gene) throws Exception;
	
	boolean agregar(Genero gene) throws Exception ;
	
	boolean eliminar(Genero gene) throws Exception ;
	

}
