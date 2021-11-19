package com.edsonb.controlepeso.services;

import org.springframework.mail.SimpleMailMessage;

import com.edsonb.controlepeso.domain.Usuario;

public interface EmailService {

	void sendCriationUserEmail(Usuario obj);

	void sendEmail(SimpleMailMessage msg);
}
