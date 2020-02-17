package com.tz.tiendazapato.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tz.tiendazapato.entidades.Producto;
import com.tz.tiendazapato.servicios.ServiceProducto;


@RestController
@RequestMapping("/producto")
public class ControllerRestProducto {

    
	@Autowired
	private ServiceProducto prodServis;
	
	@CrossOrigin
	@GetMapping("/productos")

		public Iterable<Producto> cargarProducto() {
		return prodServis.buscarAllProducto() ;
	}

}
