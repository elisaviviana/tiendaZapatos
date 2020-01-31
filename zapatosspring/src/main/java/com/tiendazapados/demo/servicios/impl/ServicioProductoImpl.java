package com.tiendazapados.demo.servicios.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.tiendazapados.demo.entidades.Producto;
import com.tiendazapados.demo.servicios.InterfazProducto;



@Service("Producto")
public class ServicioProductoImpl implements InterfazProducto {
	
	/**
	 * Genero una lista
	 */
	public List<Producto> generarLista(){
		List<Producto> miproducto = new ArrayList<Producto>();
		Producto prod;
		for(int i=0;i<=10;i++){
			prod = new Producto();
			prod.setId(new Long(i));
			prod.setCodProducto(123 + i);
			prod.setCantidad(i);
			prod.setMarca("Marca");
			prod.setModelo("Modelo "+ i);
			prod.setCategoria("Categoria"+i);
			prod.setGenero("Genero");
			prod.setDescripcion("descripcion del calzado");
		
			
			miproducto.add(prod);
		}
		return miproducto;
	}

	@Override
	public Producto encontrarPorId(Long id, List<Producto> listaConTodasLosProducto) {
		// TODO Auto-generated method stub
		for (Producto unProducto : listaConTodasLosProducto) {
			if(unProducto.getId().compareTo(id)==0){
				return unProducto;
			}
		}
		return null;
	}
}
