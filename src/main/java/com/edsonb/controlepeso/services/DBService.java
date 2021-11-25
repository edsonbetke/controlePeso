package com.edsonb.controlepeso.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.edsonb.controlepeso.domain.Peso;
import com.edsonb.controlepeso.domain.Usuario;
import com.edsonb.controlepeso.domain.enums.Perfil;
import com.edsonb.controlepeso.repositories.PesoRepository;
import com.edsonb.controlepeso.repositories.UsuarioRepository;

@Service
public class DBService {

	@Autowired
	private BCryptPasswordEncoder pe;

	@Autowired
	private PesoRepository pesoRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	public void instantiateTestDatabase() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		Usuario usuario1 = new Usuario(null, "Edson Borges", "edsonb@gmail.com", pe.encode("123"), 1.82, 35);
		Usuario usuario2 = new Usuario(null, "Taynê Santana", "taynespc@gmail.com", pe.encode("123"), 1.68, 27);
		usuario2.addPerfil(Perfil.ADMIN);

		Peso peso1 = new Peso(null, sdf.parse("30/09/2017 10:32"), 80.5, 20.0, 1.0, usuario1);
		Peso peso2 = new Peso(null, sdf.parse("01/10/2017 10:32"), 79.3, 19.9, 0.99, usuario1);
		Peso peso3 = new Peso(null, sdf.parse("30/09/2017 10:34"), 63.3, 19.9, 0.99, usuario2);

		usuario1.getPesos().addAll(Arrays.asList(peso1, peso2));
		usuario2.getPesos().addAll(Arrays.asList(peso3));

		usuarioRepository.saveAll(Arrays.asList(usuario1, usuario2));
		pesoRepository.saveAll(Arrays.asList(peso1, peso2, peso3));
	}
}
