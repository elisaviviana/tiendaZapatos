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
	public boolean editarProducto(Producto prod) {
		return false;
	}

	@Override
	public boolean agregar(Producto prod)   {
		// falta validar que el producto ya exista--- por codProducto
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

// 1-buscar en la base de datos si ese codProducto existe, si existe false, sino true--- base de datos atravez del repositorio
	  Producto prodFound =	prodRepo.findBycodProductoIs(codProducto);
		if(prodFound == null) {
			return true;	
		}
		else {
			return false;
		}
		
		
	}



}
