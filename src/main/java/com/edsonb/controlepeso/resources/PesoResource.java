package com.edsonb.controlepeso.resources;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.edsonb.controlepeso.domain.Peso;

@RestController
@RequestMapping(value = "/pesos")
public class PesoResource {

	@RequestMapping(method = RequestMethod.GET)
	public List<Peso> listar() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Peso peso1 = new Peso(1, sdf.parse("30/09/2017 10:32"), 80.5, 20.0, 1.0);
		Peso peso2 = new Peso(1, sdf.parse("01/10/2017 10:32"), 79.3, 19.9, 0.99);

		List<Peso> lista = new ArrayList<>();
		lista.add(peso1);
		lista.add(peso2);

		return lista;
	}
}
