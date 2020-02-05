package com.tz.tiendazapato.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerMarca {
	
	
	@GetMapping ("/marca")
	public String cargarMarca() {
		return "marca";
		
	}
	
	@GetMapping ("/agregarMarca")
	public String agregarMarca() {
		return "editarMarca";
		
	}
	

}
