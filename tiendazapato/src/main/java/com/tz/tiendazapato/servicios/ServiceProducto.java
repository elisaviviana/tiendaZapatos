package com.tz.tiendazapato.servicios;

import org.springframework.stereotype.Service;

import com.tz.tiendazapato.entidades.Producto;


public interface ServiceProducto {


	/**
	 * Devuelve un Producto dado un id determinado
	 * @param id el id del producto a buscar
	 * @return el Producto segun el id
	 * @throws Exception
	 */
	Producto buscarProducto(Long id) throws Exception;

	/**
	 * retorna un producto segun el codProducto
	 * @param codProducto a buscar
	 * @return Producto
	 */
	Producto buscarProductoPorCodProducto(String codProducto);
	/**
	 * Busca todas los producto guardados para mostrarlos en la lista principal
	 * @param prod
	 * @return Producto
	 */
	 Iterable<Producto>  buscarAllProducto();
	
	/**
	 * Permite editar un Producto
	 * @param movie la pelicula a editar
	 * @return true si se edito con exito
	 */
	boolean editarProducto(Producto prod);

	/**
	 * Genera una nueva pelicula en el sistema
	 * @param movie a guardar
	 * @return true si se guardo ok la pelicula
	 * @throws Exception 
	 */
	boolean agregar(Producto prod) ;
	
}
