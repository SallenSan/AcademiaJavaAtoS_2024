create table livro
(
	id serial primary key,
	isbn varchar(13) not null,
	titulo varchar(50),
	ano_publicacao int,
	fk_editora integer,
	fk_categoria integer,
	foreign key(fk_editora) references editora(id),
	foreign key(fk_categoria) references categoria(id)
)

	
create table livro_autor
(
	id serial primary key,
	fk_livro integer,
	fk_autor integer,
	foreign key (fk_livro) references livro(isbn),
	foreign key (fk_autor) references autor(id)
)


create table autor
(
	id serial primary key,
	nome varchar(50),
	nacionalidade varchar(50)
)

create table categoria
(
	id serial primary key,
	tipo_categoria varchar(50)
)

create table editora
(
	id serial primary key,
	nome varchar(50)
)

alter table livro add column id serial primary key;

alter table livro alter column isbn varchar(13);





