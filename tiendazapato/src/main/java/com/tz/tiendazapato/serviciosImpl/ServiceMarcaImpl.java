package com.tz.tiendazapato.serviciosImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tz.tiendazapato.entidades.Marca;
import com.tz.tiendazapato.repository.RepositoryMarca;
import com.tz.tiendazapato.servicios.ServiceMarca;

@Service
public class ServiceMarcaImpl implements ServiceMarca {
	@Autowired
	private RepositoryMarca marcRepo;
	

	@Override
	public Marca buscarMarca(Long id) throws Exception {
		Optional<Marca> marc=marcRepo.findById(id);
		if (marc.isPresent()) {
			return marc.get();
		}	
		else {
		throw new Exception("La Marca no esta disponible - id: "+id);
		}
	}

	@Override
	public Marca buscarMarcaPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Marca> buscarAllMarca() {
		return marcRepo.findAll();
	}

	@Override
	public boolean editarMarca(Marca marc) throws Exception {
		if(existeMarcNombre(marc.getNombre())) {
			marcRepo.save(marc);
			return true;
		}else {
			//return false;
			throw new Exception("La Marca no se puedo editar" );
		}
	}

	private boolean existeMarcNombre(String nombre) {
		Marca marcFound =	marcRepo.findBynombre(nombre);
		if(marcFound == null) {
			return false;	
		}
		else {
			return true;
		}
	}

	@Override
	public boolean agregar(Marca marc) throws Exception {
		if(!existeMarcNombre(marc.getNombre())) {
			marcRepo.save(marc);
			return true;
		}else { 
			return false;
		
		}
	}

	@Override
	public boolean eliminar(Marca marc) throws Exception {
		marc.setActivo(0);
		if(existeMarcNombre(marc.getNombre())) {
			marcRepo.save(marc);
			return true;
		}else { 
			return false;
			}
	}

}
