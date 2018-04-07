CREATE TABLE Pessoa (
	idPessoa int not null, 
	nome varchar(255) not null, 
	dataNascimento datetime not null, 
	primary key (idPessoa)
);

INSERT INTO Pessoa (idPessoa, nome, dataNascimento, sexo) VALUES (1, 'TIRIRICA', 
sysdate());

INSERT INTO Pessoa (idPessoa, nome, dataNascimento, sexo) VALUES (2, 'TIRULIPA', 
sysdate());

INSERT INTO Pessoa (idPessoa, nome, dataNascimento, sexo) VALUES (3, 'ANASTACIA', 
'31/12/1970');