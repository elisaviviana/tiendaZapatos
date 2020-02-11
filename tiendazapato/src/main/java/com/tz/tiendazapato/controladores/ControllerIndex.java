package com.tz.tiendazapato.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

	@Controller
	public class ControllerIndex {
		
		@GetMapping ("")
		public String cargarIndex() {
			return "index";
			
		}
		

	}
