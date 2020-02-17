package com.tz.tiendazapato.servicios;



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
	 * @param prod es el producto a editar
	 * @return true si se edito con exito
	 * @throws Exception 
	 */
	boolean editarProducto(Producto prod) throws Exception;

	/**
	 * Genera un nuevo producto en el sistema
	 * @param prod a guardar
	 * @return true si se guardo ok
	 * @throws Exception 
	 */
	boolean agregar(Producto prod) throws Exception ;
	boolean eliminar(Producto prod) throws Exception ;
	
}
