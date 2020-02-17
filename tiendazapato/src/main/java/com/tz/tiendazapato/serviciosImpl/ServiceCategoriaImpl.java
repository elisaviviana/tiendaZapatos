package com.tz.tiendazapato.serviciosImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tz.tiendazapato.entidades.Categoria;
import com.tz.tiendazapato.repository.RepositoryCategoria;
import com.tz.tiendazapato.servicios.ServiceCategoria;

@Service
public class ServiceCategoriaImpl implements ServiceCategoria {
	
	@Autowired
	private RepositoryCategoria categRepo;

	@Override
	public Categoria buscarCategoria(Long id) throws Exception {
		Optional<Categoria> categ=categRepo.findById(id);
		if (categ.isPresent()) {
			return categ.get();
		}	
		else {
		throw new Exception("La categoria no esta disponible - id: "+id);
		}
	}

	@Override
	public Categoria buscarCategiraPorNombre(String categNombre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Categoria> buscarAllCategoria() {
		// TODO Auto-generated method stub
		return categRepo.findAll();
	}

	@Override
	public boolean editarCategoria(Categoria categ) throws Exception {
		if(existeCatNombre(categ.getNombre())) {
			categRepo.save(categ);
			return true;
		}else {
			//return false;
			throw new Exception("La categoria no se puedo editar" );
		}
	}

	private boolean existeCatNombre(String nombre) {
		Categoria categFound =	categRepo.findBynombre(nombre);
		if(categFound == null) {
			return false;	
		}
		else {
			return true;
		}
	}

	@Override
	public boolean agregar(Categoria categ) throws Exception {
		if(!existeCatNombre(categ.getNombre())) {
			categRepo.save(categ);
			return true;
		}else { 
			return false;
			//throw new Exception("La categoria no se puedo guardar" );
		}
	}

	@Override
	public boolean eliminar(Categoria categ) throws Exception {
		categ.setActivo(0);
		if(existeCatNombre(categ.getNombre())) {
			categRepo.save(categ);
			return true;
		}else { 
			return false;
			}
	}

}
