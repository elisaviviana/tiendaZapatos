package com.tiendazapatos.zapatosspring.services;

import java.util.List;
import com.tiendazapatos.zapatosspring.entities.Entities;

public interface InterfaceServices {
	public List<Entities> generarLista();
	public Entities encontrarPorId(Long id, List<Entities> laLista);
	
}
