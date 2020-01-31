package com.tiendazapados.demo.servicios;

import java.util.List;

import com.tiendazapados.demo.entidades.MiEntidad;

public interface MiInterfazServicio {
	public List<MiEntidad> generarLista();

	public MiEntidad encontrarPorId(Long id, List<MiEntidad> laLista);
}
