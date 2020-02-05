package com.dh.demo.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.dh.demo.entidades.MiEntidad;
import com.dh.demo.entidades.Producto;
import com.dh.demo.servicios.InterfazProducto;
import com.dh.demo.servicios.MiInterfazServicio;


@Controller
public class HomeController {

	@Autowired
	@Qualifier("servicioA")
	private MiInterfazServicio servicioA; //inyectamos el servicioA pero debemos especificar con el qualifier cual es
	//porque tengo dos servicios que implementan la interfaz MiInterfazServicio

	@Autowired
	@Qualifier("servicioB")
	private MiInterfazServicio servicioB; //inyectamos el servicioB pero debemos especificar con el qualifier cual es
	//porque tengo dos servicios que implementan la interfaz MiInterfazServicio

	@Autowired
	private InterfazProducto producto; //inyectamos el producto



	@GetMapping("/")
	public String cargarListaForm(Model model) {
		model.addAttribute("editForm", new MiEntidad());
		model.addAttribute("leerList", servicioA.generarLista());
		model.addAttribute("leerListB", servicioB.generarLista());
		model.addAttribute("leerListProducto", producto.generarLista());
		model.addAttribute("listTab","active");
		return "app-form/app-view";
	}


	@GetMapping("/editarEntidad/{id}")
	public String getEditForm(Model model, @PathVariable(name ="id")Long id)throws Exception{

		//obtengo el id entonces voy a buscar el indicado

		MiEntidad entidadParaEditar = servicioA.encontrarPorId(id, servicioA.generarLista());//TODO de la lista traer el indicado por Id

		model.addAttribute("editForm", entidadParaEditar);
		model.addAttribute("leerList", servicioA.generarLista());
		model.addAttribute("leerListB", servicioB.generarLista());
		model.addAttribute("formTab","active");
		model.addAttribute("editMode","true");

		return "app-form/app-view";
	}


	@GetMapping("/appForm/cancel")
	public String cancelarEdicion(ModelMap model) {
		return "redirect:/";
	}

}
