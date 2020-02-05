package com.tz.tiendazapato.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerCategoria {

	
	@GetMapping ("/categoria")
	public String cargarCategoria() {
		return "categoria";
		
	}
	
	@GetMapping ("/agregarCategoria")
	public String agregarProducto() {
		return "editarCategoria";
	}
	

}
