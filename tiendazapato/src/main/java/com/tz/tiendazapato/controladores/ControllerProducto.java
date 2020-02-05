package com.tz.tiendazapato.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerProducto {
	@GetMapping ("/")
	public String cargarPrincipal() {
		return "index";
		
	}
	
	@GetMapping ("/producto")
	public String cargarProducto() {
		return "producto";
		
	}
	
	@GetMapping ("/agregarProducto")
	public String agregarProducto() {
		return "editarProducto";
		
	}
	

}
