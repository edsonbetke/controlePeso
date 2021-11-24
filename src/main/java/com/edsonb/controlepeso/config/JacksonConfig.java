package com.edsonb.controlepeso.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class JacksonConfig {

	@Bean
	public JavaMailSender jms() {
		return new JavaMailSenderImpl();
	}
}
