package com.edsonb.controlepeso.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.edsonb.controlepeso.domain.Usuario;
import com.edsonb.controlepeso.repositories.UsuarioRepository;
import com.edsonb.controlepeso.security.UserSS;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UsuarioRepository repo;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Usuario usuario = repo.findByEmail(email);

		if (usuario == null) {
			throw new UsernameNotFoundException(email);
		}

		return new UserSS(usuario.getId(), usuario.getEmail(), usuario.getSenha(), usuario.getPerfis());
	}

}
