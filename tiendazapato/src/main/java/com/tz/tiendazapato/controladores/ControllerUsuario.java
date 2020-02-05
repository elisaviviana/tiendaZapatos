package com.tz.tiendazapato.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerUsuario {
	@GetMapping ("/usuario")
	public String cargarProducto() {
		return "usuario";		
	}
	
	@GetMapping ("/agregarUsuario")
	public String agregarUsuario() {
		return "editarUsuario";		
	}

}
