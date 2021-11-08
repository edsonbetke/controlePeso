package com.edsonb.controlepeso.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edsonb.controlepeso.domain.Peso;
import com.edsonb.controlepeso.repositories.PesoRepository;
import com.edsonb.controlepeso.services.exceptions.ObjectNotFoundException;

@Service
public class PesoService {

	@Autowired
	private PesoRepository repo;

	public Peso find(Integer id) {
		Optional<Peso> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado!! Id: " + id + ", Tipo: " + Peso.class.getName()));
	}

	public Peso insert(Peso obj) {
		obj.setId(null);
		return repo.save(obj);
	}
}
