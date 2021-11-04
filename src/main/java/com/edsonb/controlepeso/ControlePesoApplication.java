package com.edsonb.controlepeso;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.edsonb.controlepeso.domain.Peso;
import com.edsonb.controlepeso.repositories.PesoRepository;

@SpringBootApplication
public class ControlePesoApplication implements CommandLineRunner {

	@Autowired
	private PesoRepository pesoRepository;

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

	public static void main(String[] args) {
		SpringApplication.run(ControlePesoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Peso peso1 = new Peso(null, sdf.parse("30/09/2017 10:32"), 80.5, 20.0, 1.0);
		Peso peso2 = new Peso(null, sdf.parse("01/10/2017 10:32"), 79.3, 19.9, 0.99);

		pesoRepository.saveAll(Arrays.asList(peso1, peso2));

	}

}
