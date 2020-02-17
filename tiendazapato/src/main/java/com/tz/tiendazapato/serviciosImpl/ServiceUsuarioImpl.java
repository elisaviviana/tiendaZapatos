package com.tz.tiendazapato.serviciosImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tz.tiendazapato.entidades.Usuario;
import com.tz.tiendazapato.repository.RepositoryUsuario;
import com.tz.tiendazapato.servicios.ServiceUsuario;

@Service
public class ServiceUsuarioImpl implements ServiceUsuario {
	@Autowired
	private RepositoryUsuario userRepo;

	@Override
	public Usuario buscarUsuario(Long id) throws Exception {
		Optional<Usuario> user=userRepo.findById(id);
		if (user.isPresent()) {
			return user.get();
		}	
		else {
		throw new Exception("El usuario no esta disponible - id: "+id);
		}
	}

	@Override
	public Usuario buscarUsuarioPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Usuario> buscarAllUsuario() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}

	@Override
	public boolean editarUsuario(Usuario user) throws Exception {
		if(existeUserNombre(user.getNombre())) {
			userRepo.save(user);
			return true;
		}else {
			//return false;
			throw new Exception("El usuario no se puedo editar" );
		}
	}

	private boolean existeUserNombre(String nombre) {
		Usuario userFound =	userRepo.findBynombre(nombre);
		if(userFound == null) {
			return false;	
		}
		else {
			return true;
		}
	}

	@Override
	public boolean agregar(Usuario user) throws Exception {
		if(!existeUserNombre(user.getNombre())) {
			userRepo.save(user);
			return true;
		}else { 
			return false;
		
		}
	}

	@Override
	public boolean eliminar(Usuario user) throws Exception {
		user.setActivo(0);
		if(existeUserNombre(user.getNombre())) {
			userRepo.save(user);
			return true;
		}else { 
			return false;
			}
	
	}

}
