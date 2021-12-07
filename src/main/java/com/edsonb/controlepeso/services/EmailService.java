package com.edsonb.controlepeso.services;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.SimpleMailMessage;

import com.edsonb.controlepeso.domain.Usuario;

public interface EmailService {

	void sendCriationUserEmail(Usuario obj);

	void sendEmail(SimpleMailMessage msg);

	void sendCriationUserHtmlEmail(Usuario obj);

	void sendHtmlEmail(MimeMessage msg);

	void sendNewPasswordEmail(Usuario usuario, String newPass);
}
