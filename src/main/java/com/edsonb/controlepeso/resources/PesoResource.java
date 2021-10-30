package com.edsonb.controlepeso.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/pesos")
public class PesoResource {

	@RequestMapping(method = RequestMethod.GET)
	public String listar() {
		return "REST está funcionado!!";
	}
}
