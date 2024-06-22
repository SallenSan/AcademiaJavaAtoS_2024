-- CREATE

create table filme
(
	cod_filme serial primary key,
	titulo_original varchar(100),
	titulo varchar(100),
	quantidade int,
	fk_categoria integer,
	fk_genero integer,
	foreign key(fk_categoria) references categoria(cod_categoria),
	foreign key(fk_genero) references genero(cod_genero)
)



	
create table filme_ator
(
	primary key(fk_ator, fk_filme),
	ator char(1),
	diretor char(1),
	fk_ator integer,
	fk_filme integer,
	foreign key(fk_ator) references ator(cod_ator),
	foreign key(fk_filme) references filme(cod_filme)
	
)


	
create table ator
(
	cod_ator serial primary key,
	nome varchar(60)
)


	
create table genero
(
	cod_genero serial primary key,
	nome varchar(60)
	
)


	
create table categoria
(
	cod_categoria serial primary key,
	nome varchar(60),
	valor numeric(15,2)
)

	
create table locacao_filme
(
	valor numeric(15,2),
	numero_dias int,
	data_devolucao date,
	fk_locacao integer,
	fk_filme integer,
	foreign key(fk_locacao) references locacao(cod_locacao),
	foreign key(fk_filme) references filme(cod_filme)
)


	
create table locacao
(
	cod_locacao serial primary key,
	data_locacao date,
	desconto numeric(15,2),
	multa numeric(15,2),
	sub_total numeric(15,2),
	fk_cliente integer,
	foreign key(fk_cliente) references cliente(cod_cliente)
	
)

create table cliente
(
	cod_cliente serial primary key,
	cpf varchar(11) NOT NULL CHECK (cpf ~ '^[0-9]{11}$'),
	nome varchar(60),
	telefone varchar(11),
	fk_profissao integer,
	foreign key(fk_profissao) references profissao(cod_profissao)
	
)

create table profissao
(
	cod_profissao serial primary key,
	nome varchar(60)
)

	
create table cliente_endereco
(
	primary key (fk_endereco, fk_cliente),
	fk_endereco integer,
	fk_cliente integer,
	foreign key(fk_endereco) references endereco(cod_endereco),
	foreign key(fk_cliente) references cliente(cod_cliente)
)


create table endereco
(
	cod_endereco serial primary key,
	logradouro varchar(60),
	tipo_logradouro varchar(60),
	complemento varchar(60),
	cidade varchar(100),
	uf char(2),
	cep varchar(10),
	numero varchar(10),
	bairro varchar(60)
)

create table dependente
(
	cod_dependente serial primary key,
	fk_cliente integer not null,
	parentesco varchar(20),
	foreign key(fk_cliente) references cliente(cod_cliente)
	
);

drop table dependente

--INSERCAO

-- inserir 15 filmes

insert into filme(titulo_original, titulo, quantidade, fk_categoria, fk_genero)
values('The Godfather', 'O Poderoso chefão', 10, 4, 4 )

insert into filme(titulo_original, titulo, quantidade, fk_categoria, fk_genero)
values
 ('Goodfellas', 'Os Bons Companheiros', 6, 3, 3),
('Inception', 'A Origem', 14, 3, 3),
('Fight Club', 'Clube da Luta', 10, 3, 3),
('The Lord of the Rings: The Fellowship of the Ring', 'O Senhor dos Anéis: A Sociedade do Anel', 8, 6, 6),
('The Silence of the Lambs', 'O Silêncio dos Inocentes', 13, 1, 1),
('Star Wars: Episode IV - A New Hope', 'Star Wars: Episódio IV - Uma Nova Esperança', 9, 5, 5),
('Saving Private Ryan', 'O Resgate do Soldado Ryan', 7, 3, 3),
('The Green Mile', 'À Espera de Um Milagre', 12, 1, 1);

select * from filme
	
select * from categoria
select * from genero

select * from categoria
	



-- inserir 10 clientes


-- inserir genero
INSERT INTO genero (nome) VALUES ('Drama');
INSERT INTO genero (nome) VALUES ('Horror');
INSERT INTO genero (nome) VALUES ('Action');
INSERT INTO genero (nome) VALUES ('Romance');
INSERT INTO genero (nome) VALUES ('Fiction');
INSERT INTO genero (nome) VALUES ('Fantasy');
INSERT INTO genero (nome) VALUES ('War');

-- inserir categoria
INSERT INTO categoria (nome, valor) VALUES ('Drama', 15.00);
INSERT INTO categoria (nome, valor) VALUES ('Horror', 20.00);
INSERT INTO categoria (nome, valor) VALUES ('Action', 18.00);
INSERT INTO categoria (nome, valor) VALUES ('Romance', 20.00);
INSERT INTO categoria (nome, valor) VALUES ('Fiction', 20.00);
INSERT INTO categoria (nome, valor) VALUES ('Fantasy', 10.00);
INSERT INTO categoria (nome, valor) VALUES ('War', 10.00);
