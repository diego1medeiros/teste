package br.com.cadastro.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Configuracao {

	@Bean
	ModelMapper obterModelMapper() {
		return new ModelMapper();
	}

}