package com.tz.tiendazapato.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.tz.tiendazapato.entidades.Genero;
import com.tz.tiendazapato.servicios.ServiceGenero;

	@Controller
	public class ControllerGenero {
		
		@Autowired
		private ServiceGenero geneServis;
		
		@GetMapping ("/genero")
		public String cargarGenero(Model mod) {
			mod.addAttribute("allGen", geneServis.buscarAllGenero());
			return "genero";
			
		}
		@GetMapping ("/agregarGenero")
		public String agregarGenero(Model mod) {
			mod.addAttribute("gene", new Genero());
			mod.addAttribute("nombreBoton", "Agregar Género");
			mod.addAttribute("action", "agregarGenero");
			mod.addAttribute("visibleid", false);
			return "editarGenero";
			
		}
		@GetMapping("/editarGenero")
		public String editarGenero(Model mod, @RequestParam("id") Long id) throws Exception {
		
			Genero gene = geneServis.buscarGenero(id);

			mod.addAttribute("gene", gene);
			mod.addAttribute("nombreBoton", "Editar Genero");
			mod.addAttribute("action", "editarGenero");
			mod.addAttribute("visibleid", false);
			return "editarGenero";
		}
		@GetMapping("/eliminarGenero")
		public String eliminarGenero(Model mod, @RequestParam("id") Long id) throws Exception {
			
//			EL CONTROLADOR NO BUSCA
			Genero gene = geneServis.buscarGenero(id);
			if(geneServis.eliminar(gene)) {
					mod.addAttribute("allGene", geneServis.buscarAllGenero());
			return "genero";
			}else {
				//ver hacia donde voy cuando da error el actualizar a 0 el producto
				mod.addAttribute("gene", gene);
				return "editarGenero";
			}
		}
		
		@PostMapping("/agregarGenero")
		public String agregarGeneroPost(@ModelAttribute Genero gene, BindingResult result, Model mod) throws Exception {

			boolean isOk = geneServis.agregar(gene);
			mod.addAttribute("isOk", isOk);
			if (isOk) {
				mod.addAttribute("allGene", geneServis.buscarAllGenero());

				return "genero";
			} else {
				// le devuelve el objeto prod que intento agregar y que le dio error
				mod.addAttribute("gene", gene);
				mod.addAttribute("error", true);
				mod.addAttribute("nombreBoton", "Agregar Genero");
				mod.addAttribute("action", "agregarGenero");
		
				return "editarGenero";
			}
		}

		@PostMapping("/editarGenero")
		public String editarGeneroPost(@ModelAttribute Genero gene, BindingResult result, Model mod) throws Exception {
			boolean isOK = geneServis.editarGenero(gene);
			
			mod.addAttribute("isOk", isOK);
			if (isOK) {
				mod.addAttribute("allGene", geneServis.buscarAllGenero());
				return "genero";
			} else {
				
				return "editarGenero";
			}

		}

	}
