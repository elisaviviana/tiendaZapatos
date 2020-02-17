package com.tz.tiendazapato.servicios;

import com.tz.tiendazapato.entidades.Categoria;

public interface ServiceCategoria {
	
	Categoria buscarCategoria(Long id) throws Exception;

	/**
	 * retorna un producto segun el codProducto
	 * @param codProducto a buscar
	 * @return Producto
	 */
	Categoria buscarCategiraPorNombre(String nombre);
	/**
	 * Busca todas los producto guardados para mostrarlos en la lista principal
	 * @param prod
	 * @return Producto
	 */
	 Iterable<Categoria>  buscarAllCategoria();
	
	/**
	 * Permite editar un Producto
	 * @param prod es el producto a editar
	 * @return true si se edito con exito
	 * @throws Exception 
	 */
	boolean editarCategoria(Categoria categ) throws Exception;

	/**
	 * Genera un nuevo producto en el sistema
	 * @param prod a guardar
	 * @return true si se guardo ok
	 * @throws Exception 
	 */
	boolean agregar(Categoria categ) throws Exception ;
	boolean eliminar(Categoria categ) throws Exception ;

}
