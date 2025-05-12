DROP DATABASE bd_esquak;
CREATE DATABASE bd_esquak;

USE bd_esquak;

CREATE TABLE alumnos(
alu_boleta int not null,
alu_nombre char(70),
alu_contrasenia varchar(10),
primary key (alu_boleta)
);

DESCRIBE alumnos;
SELECT * FROM alumnos;
DELETE FROM ALUMNOS WHERE alu_boleta = 2022090074;

CREATE TABLE asesores(
id_asesor int not null,
as_nombre char(70),
as_contrasenia varchar(10),
as_materia char(30) not null,
as_correo varchar(30) not null,
as_telefono int not null,
primary key (id_asesor)
);

DESCRIBE asesores;

CREATE TABLE administrador(
id_admin int not null,
ad_nombre char(30),
ad_contrasenia varchar(10),
primary key(id_admin)
);

DESCRIBE administrador;

CREATE TABLE material(
num_material int auto_increment,
nombre_archivo char(20),
contenido blob,
asesor int,
primary key(num_material),
foreign key (asesor) references asesores(id_asesor) 
);

DESCRIBE material;

CREATE TABLE asesoria(
num_asesoria int auto_increment,
materia char(15),
fecha datetime,
alumno int,
asesor int,
primary key (num_asesoria),
foreign key (alumno) references alumnos(alu_boleta),
foreign key (asesor) references asesores(id_asesor)
);

describe asesoria;

insert into administrador(id_admin, ad_nombre, ad_contrasenia) values
(0235476,'mayoneso',0123);

select * from administrador;
select * from asesores;
select * from alumnos;