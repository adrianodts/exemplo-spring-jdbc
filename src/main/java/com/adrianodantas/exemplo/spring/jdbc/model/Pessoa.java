package com.adrianodantas.exemplo.spring.jdbc.model;

import java.sql.Timestamp;

public class Pessoa {
	
	private long idPessoa;
	private String nome;
	private Timestamp dataNascimento;
		
	public Pessoa() {}
	public Pessoa(long idPessoa, String nome, Timestamp dataNascimento) {
		this.idPessoa = idPessoa;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
	}
	
	public long getIdPessoa() {
		return idPessoa;
	}
	public void setIdPessoa(long idPessoa) {
		this.idPessoa = idPessoa;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Timestamp getdataNascimento() {
		return dataNascimento;
	}
	public void setdataNascimento(Timestamp dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	@Override
	public String toString() {
		return "Pessoa [idPessoa=" + idPessoa + ", nome=" + nome + ", dataNascimento=" + dataNascimento + "]";
	}

	
	
}
