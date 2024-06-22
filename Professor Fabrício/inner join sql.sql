create table java 
(
	professor varchar(20) null
)
 
create table dotnet 
(
	professor varchar(20) null
)

insert into java values ('Fabrício'), ('Lucas'), ('Reiner')
 
insert into dotnet values ('Fabrício'), ('Ricardo')

-- SELECT
select * from dinossauros, grupos
where dinossauros.fk_grupo = grupos.id
 


-- INNER JOIN

select * from java
inner join dotnet
on java.professor = dotnet.professor

select * from dinossauros
inner join grupos
	on dinossauros.fk_grupo = grupos.id	

-- LEFT JOIN	
select * from java
left join dotnet
on java.professor = dotnet.professor

--LEFT JOIN EXCLUSIVO
select * from java
left join dotnet
on java.professor = dotnet.professor
where dotnet.professor is null

-- RIGHT JOIN
select * from java
right join dotnet
on java.professor = dotnet.professor

--RIGHT JOIN EXCLUSIVO
select * from java
right join dotnet
on java.professor = dotnet.professor
where java.professor is null

--FULL OUTER JOIN
select * from java
full outer join dotnet
on java.professor = dotnet.professor

--FULL OUTER JOIN EXCLUSIVO
select * from java
full outer join dotnet
on java.professor = dotnet.professor
where java.professor is null or dotnet.professor is null