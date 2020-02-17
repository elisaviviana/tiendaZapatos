package com.tz.tiendazapato.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tz.tiendazapato.entidades.Marca;
import com.tz.tiendazapato.servicios.ServiceMarca;

@Controller
public class ControllerMarca {
	
	@Autowired
	private ServiceMarca marcServis;
	
	@GetMapping ("/marca")
	public String cargarMarca(Model mod) {
		mod.addAttribute("allMarc", marcServis.buscarAllMarca());
		return "marca";
		
	}
	
	@GetMapping ("/agregarMarca")
	public String agregarMarca(Model mod) {
		mod.addAttribute("marc", new Marca());
		mod.addAttribute("nombreBoton", "Agregar Marca");
		mod.addAttribute("action", "agregarMarca");
		mod.addAttribute("visibleid", false);
		return "editarMarca";
		
	}
		

	@GetMapping("/editarMarca/{id}")
	public String editarMarca(Model mod, @PathVariable("id") Long id) throws Exception {
	
		Marca marc = marcServis.buscarMarca(id);

		mod.addAttribute("marc", marc);
		mod.addAttribute("nombreBoton", "Editar Marca");
		mod.addAttribute("action", "editarMarca");
		mod.addAttribute("visibleid", false);
		return "editarMarca";
	}
	@GetMapping("/eliminarMarca")
	public String eliminarMarca(Model mod, @RequestParam("id") Long id) throws Exception {
		
//		EL CONTROLADOR NO BUSCA
		Marca marc = marcServis.buscarMarca(id);
		if(marcServis.eliminar(marc)) {
				mod.addAttribute("allMarc", marcServis.buscarAllMarca());
		return "marca";
		}else {
			//ver hacia donde voy cuando da error el actualizar a 0 el producto
			mod.addAttribute("marc", marc);
			return "editarMarca";
		}
	}
	
	@PostMapping("/agregarMarca")
	public String agregarMarcaPost(@ModelAttribute Marca marc, BindingResult result, Model mod) throws Exception {

		boolean isOk = marcServis.agregar(marc);
		mod.addAttribute("isOk", isOk);
		if (isOk) {
			mod.addAttribute("allMarc", marcServis.buscarAllMarca());

			return "marca";
		} else {
			// le devuelve el objeto prod que intento agregar y que le dio error
			mod.addAttribute("marc", marc);
			mod.addAttribute("error", true);
			mod.addAttribute("nombreBoton", "Agregar Marca");
			mod.addAttribute("action", "agregarMarca");
	
			return "editarMarca";
		}
	}

	@PostMapping("/editarMarca")
	public String editarMarcaPost(@ModelAttribute Marca marc, BindingResult result, Model mod) throws Exception {
		boolean isOK = marcServis.editarMarca(marc);
		
		mod.addAttribute("isOk", isOK);
		if (isOK) {
			mod.addAttribute("allMarc", marcServis.buscarAllMarca());
			return "marca";
		} else {
			
			return "editarMarca";
		}

	}
	

}
