package com.tz.tiendazapato.serviciosImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tz.tiendazapato.entidades.Producto;
import com.tz.tiendazapato.repository.RepositoryProducto;
import com.tz.tiendazapato.servicios.ServiceProducto;

@Service
public class ServiceProductoImpl implements ServiceProducto {
	
	@Autowired
	private RepositoryProducto prodRepo;

	@Override
	public Producto buscarProducto(Long id) throws Exception {
		Optional<Producto> prod=  prodRepo.findById(id);
		if (prod.isPresent()) {
			return prod.get();
		}	
		else {
		throw new Exception("El producto no esta disponible - id: "+id);
		}
	}

	@Override
	public Producto buscarProductoPorCodProducto(String codProducto) {
		// TODO Auto-generated method stub
		return null;
	}





	@Override
	public boolean agregar(Producto prod)   throws Exception  {
		// validar que el producto ya exista--- por codProducto
		// si no existe lo guarda, sino devuelve false
		/**
		 * Si existe el Cod de producto no deja cargar uno nuevo
		 */
		if(!existeCodProd(prod.getCodProducto())) {
			prodRepo.save(prod);
			return true;
		}else { 
			return false;
			//throw new Exception("El producto no se puedo guardar" );
		}
	}
	@Override
	public boolean editarProducto(Producto prod) throws Exception {
		//validar que el id exista.. si existe se hace la modificacion..sino da error
		//si existe devuelve true, sino devuelve false
		/**
		 * Si existe el id hace la modificacion
		 */
		//if(existeCodProd(prod.getCodProducto())) {
		if(existeID(prod.getId())) {	
			prodRepo.save(prod);
			return true;
		}else {
			//return false;
			throw new Exception("El producto no se puedo editar, codigo de producto existe " );
		}
	}


	@Override
	public boolean eliminar(Producto prod) throws Exception {

		/**
		 * Marca como inactivo el producto.. en vez de eliminarlo de la base de datos
		 */
		//Producto prod = prodServis.buscarProducto(id);
		prod.setActivo(0);
		if(existeCodProd(prod.getCodProducto())) {
			prodRepo.save(prod);
			return true;
		}else { 
			return false;
			}
	}
	
	@Override
	public Iterable<Producto> buscarAllProducto() {
		// TODO Auto-generated method stub
		return  prodRepo.findAll();
		
	}
	

	private boolean existeCodProd(String codProducto) {
		/**
		 * Verificar si existe el cod de producto
		 */
		// 1-buscar en la base de datos si ese codProducto existe,
		//si existe false, sino true--- base de datos atravez del repositorio
	  Producto prodFound =	prodRepo.findBycodProductoIs(codProducto);
		if(prodFound == null) {
			return false;	
		}
		else {
			return true;
		}
	}
	
	private boolean existeID(Long id) {
		//1- buscar en la base si existe el id
		//2- si existe devuelve true, sino flase
			 if(prodRepo.existsById(id)) {
				 return true;
			 }else {
					return false;				 
			 }
	}
	





}
