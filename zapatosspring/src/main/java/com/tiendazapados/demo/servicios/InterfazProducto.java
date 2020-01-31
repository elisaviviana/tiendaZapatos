package com.tiendazapados.demo.servicios;

import java.util.List;

import com.tiendazapados.demo.entidades.Producto;

public interface InterfazProducto {
	public List<Producto> generarLista();

	public Producto encontrarPorId(Long id, List<Producto> listaProductos);
}
