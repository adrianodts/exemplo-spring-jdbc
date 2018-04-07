package com.adrianodantas.exemplo.spring.jdbc;

import java.sql.Timestamp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.adrianodantas.exemplo.spring.jdbc.model.Pessoa;
import com.adrianodantas.exemplo.spring.jdbc.repository.PessoaRepository;

@SpringBootApplication
public class ExemploSpringJdbcApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(ExemploSpringJdbcApplication.class);
	
	@Autowired
	PessoaRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(ExemploSpringJdbcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		
		Pessoa p = new Pessoa();
		p.setIdPessoa(2L);
		p.setNome("TIRULIPA");
		p.setdataNascimento(timestamp);
				
		repository.insert(p);
		logger.info("inserted -> {"+p.getIdPessoa()+"}");
		logger.info("findAll -> {}", repository.findAll());
		logger.info("findById -> {}", repository.findById(p.getIdPessoa()));
		
		p.setNome("TIRIRICA");
		p.setdataNascimento(new Timestamp(System.currentTimeMillis()));
		repository.update(p);
		logger.info("updated -> {}", repository.findById(p.getIdPessoa()));
					
		repository.delete(p.getIdPessoa());
		logger.info("deleted -> {"+p.getIdPessoa()+"}");
		logger.info("findAll -> {}", repository.findAll());
	}
}
