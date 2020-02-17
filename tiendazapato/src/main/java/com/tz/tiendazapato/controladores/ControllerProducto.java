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

import com.tz.tiendazapato.entidades.Producto;
import com.tz.tiendazapato.servicios.ServiceProducto;

@Controller
public class ControllerProducto {
	@Autowired
	private ServiceProducto prodServis;

//	@GetMapping("/")
//	public String cargarPrincipal() {
//		return "index";
//
//	}

	@GetMapping("/producto")
	/**
	 * Carga todos los productos en la table-responsive
	 * 
	 * @param mod
	 * @return al html producto
	 */
	public String cargarProducto(Model mod) {
		mod.addAttribute("allProd", prodServis.buscarAllProducto());
		return "producto";

	}

	@GetMapping("/agregarProducto")
	/**
	 * Llama al html para agregar un nuevo producto
	 * 
	 * @param mod
	 * @return html editarProducto
	 */
	public String agregarProducto(Model mod) {
		mod.addAttribute("prod", new Producto());
		mod.addAttribute("nombreBoton", "Agregar Producto");
		mod.addAttribute("action", "agregarProducto");			
		mod.addAttribute("visibleid", false);
		mod.addAttribute("visibleid", false);

		//mod.addAttribute("agregarProducto", true);LO USE PARA decidir si mostra un elemento html, 
		//pero lo saque porque el codProducto si o si tiene que estar, 
		//en el html se usa con esta sintaxi th:if="${agregarProducto}" 
		return "editarProducto";
	}	

	@GetMapping("/editarProducto/{id}")
	public String editarProducto(Model mod, @PathVariable("id") Long id) throws Exception {
	//@GetMapping("/editarProducto")
	//public String editarProducto(Model mod, @RequestParam("id") Long id) throws Exception {
			
		// buscar con el id los datos del objeto
		// obtener el objeto y pasarlo como atributo
		// le pasa el nombre del boton porque esta reusando el formulario de alta
		// si no lo encuentra deberia dar un mensaje de error
		/**
		 * Llama a editarProducto para modificar un producto
		 */
		Producto prod = prodServis.buscarProducto(id);

		mod.addAttribute("prod", prod);
		mod.addAttribute("nombreBoton", "Editar Producto");
		mod.addAttribute("action", "editarProducto");
		mod.addAttribute("visibleid", false);
	//	mod.addAttribute("agregarProducto", false); LO USE PARA decidir si mostra un elemento html, pero lo saque porque el codProducto si o si tiene que estar
		return "editarProducto";
	}
	@GetMapping("/eliminarProducto")
	public String eliminarProducto(Model mod, @RequestParam("id") Long id) throws Exception {
		// buscar con el id los datos del objeto
		// obtener el objeto y pasarlo como atributo
		// si no lo encuentra deberia dar un mensaje de error
		/**
		 * Llama a editarProducto para modificar un producto
		 */
//		EL CONTROLADOR NO BUSCA
		Producto prod = prodServis.buscarProducto(id);
		if(prodServis.eliminar(prod)) {
				mod.addAttribute("allProd", prodServis.buscarAllProducto());
		return "producto";
		}else {
			//ver hacia donde voy cuando da error el actualizar a 0 el producto
			mod.addAttribute("prod", prod);
			return "editarProducto";
		}
	}
	

	@PostMapping("/agregarProducto")
	public String agregarProductoPost(@ModelAttribute Producto prod, BindingResult result, Model mod) throws Exception {

		boolean isOk = prodServis.agregar(prod);
		mod.addAttribute("isOk", isOk);
		if (isOk) {
			mod.addAttribute("allProd", prodServis.buscarAllProducto());

			return "producto";
		} else {
			// le devuelve el objeto prod que intento agregar y que le dio error
			mod.addAttribute("prod", prod);
			mod.addAttribute("error", true);
			mod.addAttribute("nombreBoton", "Agregar Producto");
			mod.addAttribute("action", "agregarProducto");
	
			return "editarProducto";
		}
	}

	@PostMapping("/editarProducto")
	public String editarProductoPost(@ModelAttribute Producto prod, BindingResult result, Model mod) throws Exception {
		
		boolean isOK = prodServis.editarProducto(prod);
			mod.addAttribute("isOk", isOK);
		if (isOK) {
			mod.addAttribute("allProd", prodServis.buscarAllProducto());
			return "producto";
		} else {
			
			return "editarProducto";
		}

	}

}
