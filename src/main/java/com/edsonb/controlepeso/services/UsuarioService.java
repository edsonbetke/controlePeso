package com.edsonb.controlepeso.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edsonb.controlepeso.domain.Usuario;
import com.edsonb.controlepeso.repositories.UsuarioRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repo;

	public Usuario find(Integer id) throws Exception {
		Optional<Usuario> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado!! Id: " + id + ", Tipo: " + Usuario.class.getName()));
	}
}
