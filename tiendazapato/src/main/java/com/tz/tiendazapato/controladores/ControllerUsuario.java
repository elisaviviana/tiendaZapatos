package com.tz.tiendazapato.controladores;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tz.tiendazapato.entidades.Usuario;
import com.tz.tiendazapato.servicios.ServiceUsuario;
@ComponentScan(value="com.tz.tiendazapato" )
@Controller
public class ControllerUsuario {
	
	@Autowired
	private ServiceUsuario userServis;
	
	
	@GetMapping ("/usuario")
	public String cargarUsuario(Model mod) {
		mod.addAttribute("allUser", userServis.buscarAllUsuario());
		return "usuario";		
	}
	
	@GetMapping ("/agregarUsuario")
	public String agregarUsuario(Model mod) {
		mod.addAttribute("user", new Usuario());
		mod.addAttribute("nombreBoton", "Agregar Usuario");
		mod.addAttribute("action", "agregarUsuario");
		mod.addAttribute("visibleid", false);
		return "editarUsuario";		
	}
	
	
	@GetMapping("/editarUsuario/{id}")
	public String editarUsuario(Model mod, @PathVariable("id") Long id) throws Exception {
	
		Usuario user = userServis.buscarUsuario(id);

		mod.addAttribute("user", user);
		mod.addAttribute("nombreBoton", "Editar Usuario");
		mod.addAttribute("action", "editarUsuario");
		mod.addAttribute("visibleid", false);
		return "editarUsuario";
	}
	@GetMapping("/eliminarUsuario")
	public String eliminarUsuario(Model mod, @RequestParam("id") Long id) throws Exception {
		
//		EL CONTROLADOR NO BUSCA
		Usuario user = userServis.buscarUsuario(id);
		if(userServis.eliminar(user)) {
				mod.addAttribute("allUser", userServis.buscarAllUsuario());
		return "usuario";
		}else {
			//ver hacia donde voy cuando da error el actualizar a 0 el producto
			mod.addAttribute("user", user);
			return "editarUsuario";
		}
	}
	
	@PostMapping("/agregarUsuario")
	public String agregarUsuarioPost(@ModelAttribute Usuario user, BindingResult result, Model mod) throws Exception {

		boolean isOk = userServis.agregar(user);
		mod.addAttribute("isOk", isOk);
		if (isOk) {
			mod.addAttribute("allUser", userServis.buscarAllUsuario());

			return "usuario";
		} else {
			// le devuelve el objeto prod que intento agregar y que le dio error
			mod.addAttribute("user", user);
			mod.addAttribute("error", true);
			mod.addAttribute("nombreBoton", "Agregar Usuario");
			mod.addAttribute("action", "agregarUsuario");
	
			return "editarUsuario";
		}
	}

	@PostMapping("/editarUsuario")
	public String editarUsuarioPost(@ModelAttribute Usuario user, BindingResult result, Model mod) throws Exception {
		boolean isOK = userServis.editarUsuario(user);
		
		mod.addAttribute("isOk", isOK);
		if (isOK) {
			mod.addAttribute("allUser", userServis.buscarAllUsuario());
			return "usuario";
		} else {
			
			return "editarUsuario";
		}

	}

}
