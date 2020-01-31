package com.dh.demo.servicios;

import java.util.List;

import com.dh.demo.entidades.Producto;

public interface InterfazProducto {
	public List<Producto> generarLista();

	public Producto encontrarPorId(Long id, List<Producto> listaProductos);
}
