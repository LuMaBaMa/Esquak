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
as_telefono char(20) not null,
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

insert into asesoria(materia,fecha,alumno,alu_nombre,as_nombre,asesor) values 
('Probabilidad y Estadistica','2025-05-14',2022090074,'Barrios Martinez Luis Manuel','Oliver',1234);

select * from asesoria;
describe asesoria;
drop table asesoria;

insert into administrador(id_admin, ad_nombre, ad_contrasenia) values
(01234567,'mayoneso',012345);

select * from administrador;
select * from asesores;
select * from alumnos;
SELECT materia,fecha,as_nombre FROM asesoria WHERE alumno = 2022090074;