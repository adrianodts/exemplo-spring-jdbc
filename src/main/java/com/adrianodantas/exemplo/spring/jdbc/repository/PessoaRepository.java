package com.adrianodantas.exemplo.spring.jdbc.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.adrianodantas.exemplo.spring.jdbc.model.Pessoa;

@Repository
public class PessoaRepository {

	private final String SQL_FIND_ALL = "select * from Pessoa";
	private final String SQL_FIND_BY_ID = "select * from Pessoa where idPessoa = ?";
	private final String SQL_INSERT = "insert into Pessoa (idPessoa, nome, dataNascimento) values (?,?,?)";
	private final String SQL_DELETE = "delete from Pessoa where idPessoa = ?";
	private final String SQL_UPDATE = "update Pessoa set nome=?, dataNascimento=? where idPessoa = ?";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;  
	
	public List<Pessoa> findAll(){
		return jdbcTemplate.query(SQL_FIND_ALL, new PessoaRowMapper());
	}
	
	public Pessoa findById(long id){
		return jdbcTemplate.queryForObject(SQL_FIND_BY_ID, new Object[] {id}, new PessoaRowMapper());
	}

	public void insert(Pessoa pessoa) {
		jdbcTemplate.update(SQL_INSERT, new Object[] {
				pessoa.getIdPessoa(),
				pessoa.getNome(),
				pessoa.getdataNascimento()
		});
	}

	public void delete(long id) {
		jdbcTemplate.update(SQL_DELETE, new Object[] { id });
	}

	public void update(Pessoa pessoa) {
		jdbcTemplate.update(SQL_UPDATE, new Object[] {				
				pessoa.getNome(),
				pessoa.getdataNascimento(),
				pessoa.getIdPessoa()
		});
	}

	class PessoaRowMapper implements RowMapper<Pessoa>
	{
		@Override
		public Pessoa mapRow(ResultSet rs, int rowNum) throws SQLException {			
			Pessoa pessoa = new Pessoa();
			pessoa.setIdPessoa(rs.getInt("idPessoa"));
			pessoa.setNome(rs.getString("nome"));
			pessoa.setdataNascimento(rs.getTimestamp("dataNascimento"));
			return pessoa;
		}
	
	}



}
