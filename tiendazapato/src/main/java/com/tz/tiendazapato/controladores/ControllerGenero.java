package com.tz.tiendazapato.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

	@Controller
	public class ControllerGenero {
		
		@GetMapping ("/genero")
		public String cargarProducto() {
			return "genero";
			
		}
		@GetMapping ("/agregarGenero")
		public String agregarProducto() {
			return "editarGenero";
			
		}

	}
