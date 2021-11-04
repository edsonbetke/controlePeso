package com.edsonb.controlepeso.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.edsonb.controlepeso.domain.Peso;
import com.edsonb.controlepeso.services.PesoService;

@RestController
@RequestMapping(value = "/pesos")
public class PesoResource {

	@Autowired
	private PesoService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Peso obj = service.find(id);

		return ResponseEntity.ok().body(obj);
	}
}
