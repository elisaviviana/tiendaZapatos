package com.tz.tiendazapato.serviciosImpl;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tz.tiendazapato.entidades.Genero;
import com.tz.tiendazapato.repository.RepositoryGenero;
import com.tz.tiendazapato.servicios.ServiceGenero;

@Service
public class ServiceGeneroImpl implements ServiceGenero {
	
	@Autowired
	private RepositoryGenero geneRepo;

	@Override
	public Genero buscarGenero(Long id) throws Exception {
		Optional<Genero> gene=geneRepo.findById(id);
		if (gene.isPresent()) {
			return gene.get();
		}	
		else {
		throw new Exception("El genero no esta disponible - id: "+id);
		}
	}

	@Override
	public Genero buscarGeneroPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Genero> buscarAllGenero() {
		return geneRepo.findAll();
	}

	@Override
	public boolean editarGenero(Genero gene) throws Exception {
		if(existeGeneNombre(gene.getNombre())) {
			geneRepo.save(gene);
			return true;
		}else {
			//return false;
			throw new Exception("El Genero no se puedo editar" );
		}
	}

	private boolean existeGeneNombre(String nombre) {
		Genero geneFound =	geneRepo.findBynombre(nombre);
		if(geneFound == null) {
			return false;	
		}
		else {
			return true;
		}
	}

	@Override
	public boolean agregar(Genero gene) throws Exception {
		if(!existeGeneNombre(gene.getNombre())) {
			geneRepo.save(gene);
			return true;
		}else { 
			return false;
		
		}
	}

	@Override
	public boolean eliminar(Genero gene) throws Exception {
		gene.setActivo(0);
		if(existeGeneNombre(gene.getNombre())) {
			geneRepo.save(gene);
			return true;
		}else { 
			return false;
			}
	}

}
