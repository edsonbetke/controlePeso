package com.edsonb.controlepeso;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.edsonb.controlepeso.domain.Peso;
import com.edsonb.controlepeso.domain.Usuario;
import com.edsonb.controlepeso.repositories.PesoRepository;
import com.edsonb.controlepeso.repositories.UsuarioRepository;

@SpringBootApplication
public class ControlePesoApplication implements CommandLineRunner {

	@Autowired
	private PesoRepository pesoRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	public static void main(String[] args) {
		SpringApplication.run(ControlePesoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		Usuario usuario1 = new Usuario(null, "Edson Borges", "edsonb@gmail.com", "123", 1.82, 35);
		Usuario usuario2 = new Usuario(null, "Taynê Santana", "taynespc@gmail.com", "123", 1.68, 27);

		Peso peso1 = new Peso(null, sdf.parse("30/09/2017 10:32"), 80.5, 20.0, 1.0, usuario1);
		Peso peso2 = new Peso(null, sdf.parse("01/10/2017 10:32"), 79.3, 19.9, 0.99, usuario1);
		Peso peso3 = new Peso(null, sdf.parse("30/09/2017 10:34"), 63.3, 19.9, 0.99, usuario2);

		usuario1.getPesos().addAll(Arrays.asList(peso1, peso2));
		usuario2.getPesos().addAll(Arrays.asList(peso3));

		usuarioRepository.saveAll(Arrays.asList(usuario1, usuario2));
		pesoRepository.saveAll(Arrays.asList(peso1, peso2, peso3));

	}

}
