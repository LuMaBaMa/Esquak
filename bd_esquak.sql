CREATE DATABASE bd_esquak;
USE bd_esquak;

CREATE TABLE alumnos(
alu_boleta int not null,
alu_nombre char(70),
alu_telefono varchar(15),
alu_correo varchar(60),
alu_contrasenia varchar(10),
primary key (alu_boleta)
);

DESCRIBE alumnos;

CREATE TABLE asesores(
id_asesor int not null,
as_nombre char(70),
as_contrasenia varchar(10),
as_materia char(60) not null,
as_correo varchar(60) not null,
as_telefono varchar(15) not null,
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
materia char(60),
num_material int auto_increment,
nombre_archivo char(20),
contenido mediumblob,
asesor int,
primary key(num_material),
foreign key (asesor) references asesores(id_asesor) 
);

DESCRIBE material;

CREATE TABLE solicitud(
materia char(50),
alumno int,
telefono varchar(15),
correo varchar(60),
asesor int,
foreign key (alumno) references alumnos(alu_boleta),
foreign key (asesor) references asesores (id_asesor)
);

DESCRIBE solicitud;

CREATE TABLE asesoria(
num_asesoria int auto_increment,
materia char(50),
fecha datetime,
alumno int,
alu_nombre char(70),
as_nombre char(70),
asesor int,
primary key (num_asesoria),
foreign key (alumno) references alumnos(alu_boleta),
foreign key (asesor) references asesores(id_asesor)
);

DESCRIBE asesoria;

insert into asesoria(materia,fecha,alumno,alu_nombre,as_nombre,asesor) 
values ('Geometría Analítica','2025-05-28',2022090074,'Luis Manuel','Oliver',12345);
insert into administrador(id_admin, ad_nombre, ad_contrasenia) values
(01234567,'mayoneso',012345);

select * from administrador;
select * from asesores;
select * from alumnos;
select * from solicitud;
select * from asesoria;