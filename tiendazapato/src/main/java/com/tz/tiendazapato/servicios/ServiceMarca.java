package com.tz.tiendazapato.servicios;

import com.tz.tiendazapato.entidades.Marca;

public interface ServiceMarca {
	
	Marca buscarMarca(Long id) throws Exception;
	
	Marca buscarMarcaPorNombre(String nombre);
	
	Iterable<Marca>  buscarAllMarca();
	
	boolean editarMarca(Marca marc) throws Exception;
	
	boolean agregar(Marca marc) throws Exception ;
	
	boolean eliminar(Marca marc) throws Exception ;

}
