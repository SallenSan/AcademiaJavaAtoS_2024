create table locadora1

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

create table profissao
(
	cod_profissao serial primary key,
	nome varchar(60)
)

create table categoria
(
	cod_categoria serial primary key,
	nome varchar(60),
	valor numeric(15,2)
)

create table genero
(
	cod_genero serial primary key,
	nome varchar(60)
)

create table ator
(
	cod_ator serial primary key,
	nome varchar(60)
)

	
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
	ator char(1),
	diretor char(1),
	fk_ator integer,
	fk_filme integer,
	foreign key(fk_ator) references ator(cod_ator),
	foreign key(fk_filme) references filme(cod_filme)
)
 
create table cliente
(
	cod_cliente serial primary key,
	cpf varchar(11),
	nome varchar(60),
	telefone varchar(11),
	fk_profissao integer,
	foreign key(fk_profissao) references profissao(cod_profissao)
)
	
create table dependente
(
	cod_dependente serial primary key,
	fk_cliente integer,
	parentesco varchar(20),
	foreign key(fk_cliente) references cliente(cod_cliente)

) 

create table locacao
(
	cod_locacao serial primary key,
	data_locacao date,
	desconto money,
	multa money,
	sub_total money,
	fk_cliente integer,
	foreign key(fk_cliente) references cliente(cod_cliente)
)
	
create table locacao_filme
(
	valor money,
	numero_dias int,
	data_devolucao date,
	fk_locacao integer,
	fk_filme integer,
	foreign key(fk_locacao) references locacao(cod_locacao),
	foreign key(fk_filme) references filme(cod_filme)
)
 
 create table cliente_endereco
(
	fk_endereco integer,
	fk_cliente integer,
	primary key (fk_endereco, fk_cliente),
	foreign key(fk_endereco) references endereco(cod_endereco),
	foreign key(fk_cliente) references cliente(cod_cliente)
)
 
	
-------------------------------------

INSERT INTO genero (nome)
VALUES
    ('Romance'),
    ('Animação'),
    ('Comédia'),
    ('Aventura'),
    ('Crime'),
    ('Ficção Científica'),
    ('Fantasia'),
    ('Ação'),
    ('Drama'),
    ('Suspense');

SELECT * FROM genero

INSERT INTO ator (nome)
VALUES
    ('Tom Hardy'),
    ('Chris Evans'),
    ('Christopher Loyd'),
    ('Zachary Levi'),
    ('Brad Pitt'),
    ('Christoph Waltz'),
    ('Mike Myers'),
    ('Michael Fassbender'),
    ('Cameron Diaz'),
    ('Tom Hanks'),
    ('Keanu Reeves'),
    ('Diane Kruger'),
    ('Hugh Jackman'),
    ('Tina Rodriguez'),
    ('Rupert Grint');

SELECT * FROM ator

INSERT INTO categoria (nome, valor)
VALUES
    ('Romance', 15.00),
    ('Animação', 20.70),
    ('Comédia', 8.00),
    ('Aventura', 13.00),
    ('Crime', 8.60),
    ('Ficção Científica', 34.10),
    ('Fantasia', 10.00),
    ('Ação', 19.00),
    ('Drama', 33.00),
    ('Suspense', 12.00),
	('Terror', 15.00);

SELECT * FROM categoria

INSERT INTO filme (titulo_original, titulo, quantidade, fk_categoria, fk_genero)
VALUES
    ('Inglourious Bastards', 'Bastardos Inglórios', '10', 8, 8),  
    ('The terminator', 'O exterminador do futuro', '8', 8, 8),  
    ('Back to the future', 'De volta para o futuro', '12', 6, 6),  
    ('The Godfather', 'O poderoso chefão', '10', 8, 8),  
    ('Pulp Fiction', 'Pulp Fiction', '7', 8, 8),  
    ('John Wick', 'John Wick', '9', 8, 8),  
    ('John Wayne', 'John Wayne', '11', 8, 8),  
    ('O Senhor dos Anéis: A Sociedade do Anel', 'O Senhor dos Anéis: A Sociedade do Anel', '6', 7, 7),  
    ('Forrest Gump', 'Forrest Gump', '8', 9, 8),  
    ('Interestelar', 'Interestelar', '10', 6, 6),  
    ('Cars', 'Carros', '6', 2, 2),  
    ('Jurassic Park', 'Jurassic Park', '7', 6, 6),  
    ('Spider-man', 'Homem-aranha', '9', 8, 8),  
    ('The avengers', 'Os Vingadores', '12', 8, 8),  
    ('The punisher', 'O justiceiro', '8', 8, 8);  

SELECT * FROM filme

INSERT INTO profissao (nome)
VALUES
    ('Engenheiro'),
    ('Advogado'),
    ('Policial'),
    ('Analista de sistemas');

SELECT * FROM profissao

INSERT INTO cliente (cpf, nome, telefone, fk_profissao)
VALUES 
    ('88765432100', 'Juliano Akira', '4397654332', 4),
    ('90345678900', 'Thomas Oliver', '4391416633', 1), 
    ('56789012300', 'Pedro Santos', '4396543210', 3),
    ('44567890100', 'Ana Beatriz Oliveira', '5595439023', 4),
    ('90123455788', 'Ana Costa', '6594321790', 2),
    ('23456789999', 'Beatriz Oliveira', '1193217674', 3),
    ('67890123400', 'Marcos Santos', '5599995578', 2),
    ('45698701200', 'Luiza Pereira', '5599998888', 2),
    ('82232345600', 'Fernanda Freitas', '1197653331', 3),
    ('02234567800', 'Rafaela Almeida', '6796543217', 4);

SELECT * FROM cliente

INSERT INTO locacao (data_locacao, desconto, multa, sub_total, fk_cliente)
VALUES
    ('2024-06-01', 0, 0, 50.00, 1), 
    ('2024-06-03', 5.00, 0, 45.00, 2),
    ('2024-06-05', 0, 3.50, 55.00, 3),
    ('2024-06-07', 0, 0, 60.00, 4),
    ('2024-06-10', 0, 0, 40.00, 5),
    ('2024-06-12', 2.00, 0, 48.00, 6),
    ('2024-06-14', 0, 0, 70.00, 7),
    ('2024-06-17', 0, 0, 35.00, 8),
    ('2024-06-19', 0, 0, 42.00, 9),
    ('2024-06-21', 0, 0, 65.00, 1),  
    ('2024-06-24', 0, 0, 38.00, 2),  
    ('2024-06-26', 1.50, 0, 47.00, 3),  
    ('2024-06-28', 0, 0, 58.00, 4),  
    ('2024-07-01', 0, 4.00, 52.00, 5),  
    ('2024-07-03', 0, 0, 44.00, 6),  
    ('2024-07-05', 3.00, 0, 57.00, 7), 
    ('2024-07-08', 0, 0, 62.00, 8),  
    ('2024-07-10', 0, 0, 36.00, 9),  
    ('2024-07-12', 0, 0, 49.00, 1),  
    ('2024-07-14', 0, 0, 68.00, 2); 

SELECT * FROM locacao

INSERT INTO dependente (fk_cliente, parentesco)
VALUES
    ( 1, 'Filho'),
    ( 1, 'Filha'),
    ( 3, 'Esposa'),
    ( 5, 'esposa'),
    ( 6, 'Esposo'),
    ( 7, 'Esposa'),
    ( 8, 'Filho'),
    ( 9, 'Filho'),
    ( 10, 'Esposa'),
    ( 10, 'Filho');

SELECT * FROM dependente

INSERT INTO locacao_filme (valor, numero_dias, data_devolucao, fk_locacao, fk_filme)
VALUES
    (20.00, 100,'2024-06-04',1, 2),
    (12.00, 77, '2024-06-03',2, 3),
    (13.00, 78, '2024-06-07',3, 3),
    (4.00, 79,'2024-06-04',4, 2 ),
    (2.50, 80,'2024-06-08', 5, 4),
    (2.90, 81,'2024-06-06', 6, 2),
    (2.70, 82, '2024-06-12', 6, 7),
    (7.00, 83,'2024-06-09', 7, 4),
    (5.00, 84, '2024-06-13', 7, 10),
    (10.00, 85, '2024-06-11', 7, 7),
    (15.00, 86,'2024-06-14', 9, 9),
    (12.00, 86,'2024-06-14',10, 9 ),
    (12.00, 86,'2024-06-14', 10, 11),
    (13.50, 86,'2024-06-14', 5, 6),
    (13.50, 87,'2024-06-14', 11, 9),
    (22.00, 86,'2024-06-14', 15, 15),
    (15.00, 86,'2024-06-14', 10, 15),
    (14.50, 86,'2024-06-14', 11,12 ),
    (13.89, 90,'2024-06-14', 15,12 ),
    (20.00, 90,'2024-06-14', 20, 5),
    (31.00, 90,'2024-06-14', 13, 15),
    (31.00, 90,'2024-06-14', 12,13),
    (20.00, 90,'2024-06-14', 13, 12),
    (20.00, 86,'2024-06-14', 17, 15),
    (31.00, 90,'2024-06-14', 1, 15),
    (31.00, 80,'2024-06-14', 3, 14),
    (3.00, 86,'2024-06-14', 2, 13),
    (31.99, 86,'2024-06-14', 18, 14),
    (15.00, 86,'2024-06-14', 19,10 ),
    (31.00, 100,'2024-06-14', 20, 11);

SELECT * FROM locacao_filme

INSERT INTO filme_ator (ator, diretor, fk_ator, fk_filme)
VALUES
    ('S', 'N', 1, 1),
    ('S', 'N', 2, 2),
    ('S', 'N', 3, 3),
    ('S', 'N', 4, 4),
    ('S', 'N', 5, 5),
    ('S', 'N', 6, 6),
    ('S', 'N', 7, 7),
    ('S', 'N', 8, 8),
    ('S', 'N', 9, 9),
    ('S', 'N', 10, 10),
    ('S', 'N', 11, 12),
    ('S', 'N', 12, 13),
    ('S', 'N', 13, 11),
    ('S', 'N', 14, 15),
    ('N', 'N', 15, 14);

SELECT * FROM filme_ator

INSERT INTO endereco ( logradouro, tipo_logradouro, complemento, cidade, uf, cep, numero, bairro)
VALUES
    ( 'Rua Onofre de Luca', 'Rua', 'Casa', 'Ibiporã', 'PR', '86200000', '100', 'Centro'),
    ( 'Av. Higienopolis', 'Avenida', 'Sala 302', 'Londirna', 'SP', '86200000', '500', 'Bela Vista'),
    ( 'Rua Galileia', 'Rua', 'Casa 10', 'Ibiporã', 'PR', '86200123', '200', 'Centro'),
    ('Av. Higienopolis', 'Avenida', 'Bloco A', 'Londrina', 'PR', '86200000', '1001', 'Centro'),
    ( 'Rua das Dalias', 'Rua', 'Casa 5', 'Ibiporã', 'PR', '8620000', '50', 'Centro');

SELECT * FROM endereco

INSERT INTO cliente_endereco (fk_endereco, fk_cliente)
VALUES
    (1, 1),
    (2, 2),
    (3, 3),
    (4, 4),
    (5, 5),
    (1, 6),
    (2, 7),
    (3, 8),
    (4, 9),
    (5, 10);

SELECT * FROM cliente_endereco
 

// exercicios
1  - Listar todos os filmes alugados por um cliente específico, incluindo a data de locação e a data de devolução.
	SELECT 
    cliente.nome AS cliente_nome,
    filme.titulo AS filme_titulo,
    locacao.data_locacao,
    locacao_filme.data_devolucao
FROM 
    cliente
JOIN 
    locacao ON cliente.cod_cliente = locacao.fk_cliente
JOIN 
    locacao_filme ON locacao.cod_locacao = locacao_filme.fk_locacao
JOIN 
    filme ON locacao_filme.fk_filme = filme.cod_filme
WHERE 
    cliente.cod_cliente = 1;


	
2  - Obter uma lista de clientes e seus dependentes.
SELECT 
    cliente.cod_cliente AS cliente_id,
    cliente.nome AS cliente_nome,
    dependente.cod_dependente AS dependente_id,
    dependente.parentesco,
    dependente.fk_cliente AS cliente_id_associado
FROM 
    cliente
LEFT JOIN 
    dependente ON cliente.cod_cliente = dependente.fk_cliente
ORDER BY 
    cliente.cod_cliente, dependente.cod_dependente;
	
3  - Listar todos os filmes de um determinado gênero.
SELECT 
    filme.cod_filme AS filme_id,
    filme.titulo AS filme_titulo,
    genero.nome AS genero_nome
FROM 
    filme
JOIN 
    genero ON filme.fk_genero = genero.cod_genero
WHERE 
    genero.nome = 'Ação';
	
4  - Exibir todos os clientes que têm uma profissão específica.

SELECT 
    cliente.cod_cliente AS cliente_id,
    cliente.nome AS cliente_nome,
    profissao.nome AS profissao_nome
FROM 
    cliente
JOIN 
    profissao ON cliente.fk_profissao = profissao.cod_profissao
WHERE 
    profissao.nome = 'Engenheiro';
	
5  - Encontrar todos os filmes em uma categoria específica com quantidade disponível maior que 5.
SELECT 
    filme.cod_filme AS filme_id,
    filme.titulo AS filme_titulo,
    categoria.nome AS categoria_nome,
    filme.quantidade
FROM 
    filme
JOIN 
    categoria ON filme.fk_categoria = categoria.cod_categoria
WHERE 
    categoria.nome = 'Ação'
    AND filme.quantidade > 5;


	
6  - Listar todos os atores que participaram de filmes com um determinado título.
SELECT 
    ator.cod_ator AS ator_id,
    ator.nome AS ator_nome,
    filme.titulo AS filme_titulo
FROM 
    ator
JOIN 
    filme_ator ON ator.cod_ator = filme_ator.fk_ator
JOIN 
    filme ON filme_ator.fk_filme = filme.cod_filme
WHERE 
    filme.titulo = 'Inglourious Bastards';
	
7  - Obter o endereço completo de um cliente específico.
SELECT 
    cliente.nome AS cliente_nome,
    endereco.logradouro,
    endereco.tipo_logradouro,
    endereco.complemento,
    endereco.cidade,
    endereco.uf,
    endereco.cep,
    endereco.numero,
    endereco.bairro
FROM 
    cliente
JOIN 
    cliente_endereco ON cliente.cod_cliente = cliente_endereco.fk_cliente
JOIN 
    endereco ON cliente_endereco.fk_endereco = endereco.cod_endereco
WHERE 
    cliente.cod_cliente = 1;
	
8  - Listar todos os filmes e seus respectivos gêneros e categorias.
SELECT 
    filme.cod_filme AS filme_id,
    filme.titulo AS filme_titulo,
    genero.nome AS genero_nome,
    categoria.nome AS categoria_nome
FROM 
    filme
JOIN 
    genero ON filme.fk_genero = genero.cod_genero
JOIN 
    categoria ON filme.fk_categoria = categoria.cod_categoria;

9  - Mostrar todos os clientes que alugaram um filme específico e a data de locação.
SELECT 
    cliente.cod_cliente AS cliente_id,
    cliente.nome AS cliente_nome,
    locacao.data_locacao,
    filme.titulo AS filme_titulo
FROM 
    cliente
JOIN 
    locacao ON cliente.cod_cliente = locacao.fk_cliente
JOIN 
    locacao_filme ON locacao.cod_locacao = locacao_filme.fk_locacao
JOIN 
    filme ON locacao_filme.fk_filme = filme.cod_filme
WHERE 
    filme.titulo = 'Interestelar';

10 - Exibir a lista de clientes com multas superiores a um valor específico.

SELECT 
    cliente.cod_cliente AS cliente_id,
    cliente.nome AS cliente_nome,
    SUM(locacao.multa) AS total_multas
FROM 
    cliente
JOIN 
    locacao ON cliente.cod_cliente = locacao.fk_cliente
GROUP BY 
    cliente.cod_cliente, cliente.nome
HAVING 
    SUM(locacao.multa) > 5.00::money; 

11 - Listar todas as locações feitas em um período específico.

SELECT 
    locacao.cod_locacao AS cod_locacao,
    cliente.nome AS cliente_nome,
    locacao.data_locacao,
    locacao.desconto,
    locacao.multa,
    locacao.sub_total
FROM 
    locacao
JOIN 
    cliente ON locacao.fk_cliente = cliente.cod_cliente
WHERE 
    locacao.data_locacao BETWEEN '2024-06-01' AND '2024-06-30';


	
12 - Obter a quantidade total de filmes alugados por cada cliente.

SELECT 
    cliente.cod_cliente AS cliente_id,
    cliente.nome AS cliente_nome,
    COUNT(*) AS total_filmes_alugados
FROM 
    cliente
JOIN 
    locacao ON cliente.cod_cliente = locacao.fk_cliente
JOIN 
    locacao_filme ON locacao.cod_locacao = locacao_filme.fk_locacao
GROUP BY 
    cliente.cod_cliente, cliente.nome
ORDER BY 
    total_filmes_alugados DESC;


13 - Listar os clientes e os filmes que eles alugaram, ordenados por data de locação.
SELECT 
    cliente.cod_cliente AS cliente_id,
    cliente.nome AS cliente_nome,
    locacao.data_locacao,
    filme.titulo AS titulo_filme
FROM 
    cliente
JOIN 
    locacao ON cliente.cod_cliente = locacao.fk_cliente
JOIN 
    locacao_filme ON locacao.cod_locacao = locacao_filme.fk_locacao
JOIN 
    filme ON locacao_filme.fk_filme = filme.cod_filme
ORDER BY 
    locacao.data_locacao;


14 - Mostrar todos os clientes que moram em uma cidade específica e que alugaram filmes de uma categoria específica.

SELECT 
    cliente.cod_cliente AS cliente_id,
    cliente.nome AS cliente_nome,
    endereco.cidade,
    filme.titulo AS titulo_filme,
    categoria.nome AS nome_categoria
FROM 
    cliente
JOIN 
    cliente_endereco ON cliente.cod_cliente = cliente_endereco.fk_cliente
JOIN 
    endereco ON cliente_endereco.fk_endereco = endereco.cod_endereco
JOIN 
    locacao ON cliente.cod_cliente = locacao.fk_cliente
JOIN 
    locacao_filme ON locacao.cod_locacao = locacao_filme.fk_locacao
JOIN 
    filme ON locacao_filme.fk_filme = filme.cod_filme
JOIN 
    categoria ON filme.fk_categoria = categoria.cod_categoria
WHERE 
    endereco.cidade = 'Londrina'  
    AND categoria.nome = 'Ação'  
ORDER BY 
    cliente.nome, locacao.data_locacao;


15 - Encontrar todos os atores que participaram de pelo menos 5 filmes, listando o nome do ator e o número de filmes em que atuou. (DESAFIO)

	SELECT
    ator.nome AS nome_ator,
    COUNT(filme_ator.fk_filme) AS numero_filmes
FROM
    ator
JOIN
    filme_ator ON ator.cod_ator = filme_ator.fk_ator
GROUP BY
    ator.cod_ator, ator.nome
HAVING
    COUNT(filme_ator.fk_filme) >= 5
ORDER BY
    numero_filmes DESC, nome_ator;

	
16 - Exibir a quantidade total de filmes alugados por categoria e gênero, incluindo apenas as categorias e gêneros que têm mais de 5 filmes alugados no total (DESAFIO)

SELECT
    c.nome AS categoria,
    g.nome AS genero,
    COUNT(lf.fk_filme) AS total_filmes_alugados
FROM
    locacao_filme lf
JOIN
    filme f ON lf.fk_filme = f.cod_filme
JOIN
    categoria c ON f.fk_categoria = c.cod_categoria
JOIN
    genero g ON f.fk_genero = g.cod_genero
GROUP BY
    c.nome, g.nome
HAVING
    COUNT(lf.fk_filme) > 5
ORDER BY
    total_filmes_alugados DESC;


	

 

 

	

 

