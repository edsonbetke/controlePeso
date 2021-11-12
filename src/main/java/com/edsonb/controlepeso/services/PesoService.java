package com.edsonb.controlepeso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.edsonb.controlepeso.domain.Peso;
import com.edsonb.controlepeso.dto.PesoDTO;
import com.edsonb.controlepeso.repositories.PesoRepository;
import com.edsonb.controlepeso.services.exceptions.DataIntegrityException;
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

	public Peso update(Peso obj) {
		Peso newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}

	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityException e) {
			throw new DataIntegrityException("Não é possível excluir um peso");
		}
	}

	public List<Peso> findAll() {
		return repo.findAll();
	}

	public Page<Peso> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);

		return repo.findAll(pageRequest);
	}

	public Peso fromDTO(PesoDTO objDto) {
		return new Peso(objDto.getId(), null, objDto.getPeso(), null, null, null);
	}

	private void updateData(Peso newObj, Peso obj) {
		newObj.setPeso(obj.getPeso());
	}
}
