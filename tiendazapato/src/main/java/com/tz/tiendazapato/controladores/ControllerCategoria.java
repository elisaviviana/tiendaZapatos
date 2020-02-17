package com.tz.tiendazapato.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.tz.tiendazapato.entidades.Categoria;
import com.tz.tiendazapato.servicios.ServiceCategoria;

@Controller
public class ControllerCategoria {
	@Autowired
	private ServiceCategoria categServis;
	
	@GetMapping ("/categoria")
	public String cargarCategoria(Model mod) {
		mod.addAttribute("allCateg",categServis.buscarAllCategoria());
		return "categoria";
		
	}
	
	@GetMapping ("/agregarCategoria")
	public String agregarCategoria(Model mod) {
		mod.addAttribute("categ", new Categoria());
		mod.addAttribute("nombreBoton", "Agregar Categoria");
		mod.addAttribute("action", "agregarCategoria");
		mod.addAttribute("visibleid", false);
		return "editarCategoria";
	}
	@GetMapping("/editarCategoria")
	public String editarCategoria(Model mod, @RequestParam("id") Long id) throws Exception {
		// buscar con el id los datos del objeto
		// obtener el objeto y pasarlo como atributo
		// le pasa el nombre del boton porque esta reusando el formulario de alta
		// si no lo encuentra deberia dar un mensaje de error
		/**
		 * Llama a editarProducto para modificar un producto
		 */
		Categoria categ = categServis.buscarCategoria(id);

		mod.addAttribute("categ", categ);
		mod.addAttribute("nombreBoton", "Editar Categoria");
		mod.addAttribute("action", "editarCategoria");
		mod.addAttribute("visibleid", false);
		return "editarCategoria";
	}
	@GetMapping("/eliminarCategoria")
	public String eliminarCategoria(Model mod, @RequestParam("id") Long id) throws Exception {
		// buscar con el id los datos del objeto
		// obtener el objeto y pasarlo como atributo
		// si no lo encuentra deberia dar un mensaje de error
		/**
		 * Llama a editarProducto para modificar un producto
		 */
//		EL CONTROLADOR NO BUSCA
		Categoria categ = categServis.buscarCategoria(id);
		if(categServis.eliminar(categ)) {
				mod.addAttribute("allCateg", categServis.buscarAllCategoria());
		return "categoria";
		}else {
			//ver hacia donde voy cuando da error el actualizar a 0 el producto
			mod.addAttribute("categ", categ);
			return "editarCategoria";
		}
	}
	
	@PostMapping("/agregarCategoria")
	public String agregarCategoriaPost(@ModelAttribute Categoria categ, BindingResult result, Model mod) throws Exception {

		boolean isOk = categServis.agregar(categ);
		mod.addAttribute("isOk", isOk);
		if (isOk) {
			mod.addAttribute("allCateg", categServis.buscarAllCategoria());

			return "categoria";
		} else {
			// le devuelve el objeto prod que intento agregar y que le dio error
			mod.addAttribute("categ", categ);
			mod.addAttribute("error", true);
			mod.addAttribute("nombreBoton", "Agregar Categoria");
			mod.addAttribute("action", "agregarCategoria");
	
			return "editarCategoria";
		}
	}

	@PostMapping("/editarCategoria")
	public String editarCategoriaPost(@ModelAttribute Categoria categ, BindingResult result, Model mod) throws Exception {
		boolean isOK = categServis.editarCategoria(categ);
		
		mod.addAttribute("isOk", isOK);
		if (isOK) {
			mod.addAttribute("allCateg", categServis.buscarAllCategoria());
			return "categoria";
		} else {
			
			return "editarCategoria";
		}

	}
	

}
