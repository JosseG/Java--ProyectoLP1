
drop database if exists ReservaHotel;
create database ReservaHotel;
use ReservaHotel;

create table direccion(
id_direccion char(8) primary key,
pais_direccion varchar(30) not null
);

create table cliente(
id_cliente int primary key auto_increment,
nombre_cliente varchar(30) not null,
apellido_cliente varchar(60) not null,
docIndentidad_cliente char(11) not null,
celular_cliente varchar(9) not null,
correo_cliente varchar(60),
id_direccion char(8) not null,
foreign key(id_direccion) references direccion(id_direccion)
);


create table habitacion(
id_hab char(4) primary key not null,
tipo_hab char(1) not null,
FechaReserva_hab date  not null,
NumDias_hab int not null,
descripcion_hab varchar(90) not null,
check(tipo_hab in ('0','1', '2'))
);

create table rol(
id_rol char(2) primary key not null,
nombre_rol varchar(15) not null
);

create table empleado(
id_emp char(3) primary key not null,
id_rol char(2) not null,
docIndentidad_emp char(11) not null,   
nombre_emp varchar(40) not null,
apellido_emp varchar(60) not null,
celular_emp varchar(9) not null,
correo_emp varchar(60) not null,
foreign key(id_rol) references rol(id_rol)
);



create table cuenta(
id_cuenta char(4) primary key not null,
id_emp char(3) not null,
username_cuenta varchar(30) not null,
password_cuenta varchar(30) not null,
foreign key(id_emp) references empleado(id_emp)
);

create table login(
id_login int primary key auto_increment,
id_cuenta char(4) not null,
fecha_login datetime not null,
foreign key(id_cuenta) references cuenta(id_cuenta)
);


create table boleta(
id_boleta char(9) primary key,
id_emp char(3) not null,
fecha_boleta date not null,
ruc_boleta char(11) not null,
tipoPago_boleta varchar(15) not null,
foreign key(id_emp) references empleado(id_emp)
);

create table detalleboleta(
id_boleta char(9) not null,
id_cliente int not null,
id_hab char(4) not null,
precioHab_dBoleta double not null,
precioHabExtra_dBoleta double not null,
foreign key(id_boleta) references boleta(id_boleta),
foreign key(id_cliente) references cliente(id_cliente),
foreign key(id_hab) references habitacion(id_hab),
primary key(id_boleta,id_cliente,id_hab),
check( precioHabExtra_dBoleta= 50 or precioHabExtra_dBoleta=70 or precioHabExtra_dBoleta=80)
);

-- insert temporales
insert into direccion values ('DIR00001', 'Peru'),
('DIR00002', 'Brasil'),
('DIR00003','Argentina'),
('DIR00004','Colombia'),
('DIR00005','Colombia'),
('DIR00006','Uruguay'),
('DIR00007','Paraguay'),
('DIR00008','Bolivia'),
('DIR00009','Bolivia');
select * from direccion;

insert into cliente values (1,'Luis', 'Torres Torres', '00012345678','998875643','luis@gmail.com', 'DIR00001'),
(2,'Sebastian', 'Torres Cañari', '00012395678','998875223','sebastian@gmail.com', 'DIR00002');

insert into cliente values
('3','Yeder','Gonzales Garcia','00012391021','928912031','yeder@gmail.com','DIR00003'),
('4','Angel','Castillo Quispe','00012301921','900182212','angel@gmail.com','DIR00004'),
('5','Pedro','Gironda Armando','00012372191','974201245','pedro@gmail.com','DIR00005'),
('6','Maria','Maldini Pastor','00012381021','998876421','maria@gmail.com','DIR00006'),
('7','Fernanda','Alvarez Vazquez','00012300912','920182931','fernanda@gmail.com','DIR00007'),
('8','Edith','Díaz Chávez','00012355915','920129310','edith@gmail.com','DIR00008'),
('9','Nicole','Torres Jugo','00012319212','982201021','nicole@gmail.com','DIR00009');
select * from cliente;
select * from cliente;

insert into habitacion values ('H001','1', '2021-03-23',3 ,'tv con cable' ),
('H002','1', '2021-03-29',3 ,'tv con cable');

insert into habitacion values 
('H003','1', '2021-05-23',3 ,'tv con cable y piscina' ),
('H004','2', '2021-03-09',3 ,'tv sin cable'),
('H005','1', '2021-01-25',3 ,'tv con cable y piscina' ),
('H006','2', '2021-06-19',3 ,'tv sin cable'),
('H007','1', '2021-07-28',3 ,'tv sin cable' ),
('H008','1', '2021-07-22',3 ,'tv con cable'),
('H009','2', '2021-07-21',3 ,'tv con cable y piscina' );
select * from habitacion;

insert into rol values ('R1','Administrador'),
('R2','recepcionista');
select * from rol;



insert into empleado values ('E01','R1', '00012395578', 'Maria', 'Castillo Parado', '987654321', 'maria@gmail.com'),
('E02','R1', '00019395578', 'Jorge', 'Castillo Cerca', '987659321', 'jorge@gmail.com');

insert into empleado values 
('E03','R1', '00012910211', 'Mara', 'Quispe León', '902102121', 'mara@gmail.com'),
('E04','R2', '00012029102', 'Manuel', 'Garcia Quispe', '929201411', 'manuel@gmail.com'),
('E05','R1', '00012038122', 'Manuela', 'Gutierrez Rosas', '987222012', 'manuela@gmail.com'),
('E06','R1', '00012930120', 'Alex', 'Flores Cruz', '912031021', 'alex@gmail.com'),
('E07','R1', '00012192031', 'Alejandra', 'Hakimi Chunta', '999212441', 'alejandra@gmail.com'),
('E08','R2', '00010091291', 'Juan', 'Alvarado Perez', '987654001', 'juan@gmail.com'),
('E09','R1', '00019920123', 'Alvaro', 'Castillo Perez', '912345001', 'alvaro@gmail.com');
select * from empleado;



insert into cuenta values ('CT01','E01', 'Maria', 'Maria1234'),
('CT02','E02', 'Milagros', 'Milagros1234');

insert into cuenta values 
('CT03','E03', 'Jose', 'Jose1234'),
('CT04','E04', 'Andres', 'Andres1234'),
('CT05','E05', 'Marco', 'Marco1234'),
('CT06','E06', 'Alexandra', 'Alexandra1234'),
('CT07','E07', 'Camila', 'Camila1234'),
('CT08','E08', 'Mirta', 'Mirta1234'),
('CT09','E09', 'Mariana', 'Mariana1234');
select * from cuenta;

insert into login values ('1','CT02', '2021-05-23'),
('2','CT01', '2021-05-24');
select * from login;

insert into boleta values ('B00000001','E01', '2021-05-28', '2345678900', 'efectivo'),
('B00000002','E02', '2021-07-28', '2345678100', 'efectivo');

insert into boleta values 
('B00000003','E03', '2021-07-29', '2345678200', 'tarjeta'),
('B00000004','E04', '2021-07-30', '2345678300', 'efectivo'),
('B00000005','E05', '2021-08-02', '2345678400', 'efectivo'),
('B00000006','E06', '2021-08-05', '2345678500', 'tarjeta'),
('B00000007','E07', '2021-08-06', '2345678600', 'efectivo'),
('B00000008','E08', '2021-08-07', '2345678130', 'tarjeta'),
('B00000009','E09', '2021-09-10', '2345678120', 'efectivo');
select * from boleta;

insert into detalleboleta values ('B00000001',1, 'H001', '123', '70'),
('B00000001',2, 'H002', '234', '50');

insert into detalleboleta values 
('B00000002',3, 'H003', '230', '70'),
('B00000003',4, 'H004', '200', '70'),
('B00000004',5, 'H005', '150', '50'),
('B00000005',6, 'H006', '180', '50'),
('B00000006',7, 'H007', '123', '80'),
('B00000007',8, 'H008', '205', '70'),
('B00000008',9, 'H009', '126', '70');
select * from detalleboleta;

-- ----------------------------------------------------------------
-- PROCEDIMIENTOS ALMACENADOS
-- ----------------------------------------------------------------

-- REGISTRO DE HABITACIONES----------------------------------------
-- ListarHabitacion
drop procedure if exists listarHabitacion;
delimiter @@
create procedure listarHabitacion()
begin
	select * from habitacion;
end @@
delimiter ;
call listarHabitacion();

-- AñadirHabitacion
drop procedure if exists AnadirHabitacion;
delimiter @@
create procedure AnadirHabitacion(id char(4), tipo char(1), fechareserva date, numdias int, descrip varchar(90))
begin
	insert into habitacion values(id, tipo, fechareserva, numdias, descrip);
end @@
delimiter ;
/*call AnadirHabitacion('1113','2', '2021-05-23',3 ,'agua caliente');*/

-- ModificarHabitacion
drop procedure if exists ModificarHabitacion;
delimiter @@
create procedure ModificarHabitacion(id char(4), tipo char(1), fechareserva date, numdias int, descrip varchar(90))
begin
	update habitacion set  tipo_hab = tipo, FechaReserva_hab = fechareserva, NumDias_hab=numdias, descripcion_hab= descrip  where id_hab = id;
end @@
delimiter ;
/*call ModificarHabitacion('1112','2', '2021-03-29',3 ,'tv con cable');*/

-- ConsultarHabitacionId
drop procedure if exists ConsultarHabitacionId;
delimiter @@
create procedure ConsultarHabitacionId(id char(4))
begin
	select * from Habitacion where id_hab like (Concat(concat('%',id),'%'));
end @@
delimiter ;
call ConsultarHabitacionId('1');

-- ConsultarHabitacionId
drop procedure if exists ConsultarHabitacionTipo;
delimiter @@
create procedure ConsultarHabitacionTipo(tipo char(4))
begin
	select * from Habitacion where tipo_hab like (Concat(concat('%',tipo),'%'));
end @@
delimiter ;
/*call ConsultarHabitacionTipo('2');*/



-- EliminarHabitacion
drop procedure if exists EliminarHabitacion;
delimiter @@
create procedure EliminarHabitacion(id char(4))
begin
	delete from habitacion where id_hab = id;
end @@
delimiter ;
/*call EliminarHabitacion('1113');*/


-- REGISTRO DE CLIENTE----------------------------------
-- ListarCliente
drop procedure if exists ListarCliente;
delimiter @@
create procedure ListarCliente()
begin
	select * from cliente;
end @@
delimiter ;
call ListarCliente();

-- AñadirCliente
drop procedure if exists AnadirCliente;
delimiter @@
create procedure AnadirCliente(id_cli int, nom_cli varchar(30), ape_cli varchar(60), doc_cli char(11), celular_cli varchar(9), co_cli varchar(60), dir_cli char(8))
begin
	insert into cliente values(id_cli, nom_cli, ape_cli, doc_cli, celular_cli, co_cli, dir_cli);
end @@
delimiter ;
/*call AnadirCliente(3,'sebastian', 'Torres Cañari', '00012395678','998875223','sebastian@gmail.com', 'DIR00002');*/

-- ModificarCliente
drop procedure if exists ModificarCliente;
delimiter @@
create procedure ModificarCliente(id_cli int, nom_cli varchar(30), ape_cli varchar(60), doc_cli char(11), celular_cli varchar(9), co_cli varchar(60), dir_cli char(8))
begin
	update cliente set  nombre_cliente= nom_cli, apellido_cliente = ape_cli, docIndentidad_cliente=doc_cli ,celular_cliente = celular_cli, correo_cliente= co_cli, id_direccion = dir_cli where id_cliente = id_cli;
end @@
delimiter ;
/*call ModificarCliente(3,'Juan', 'torres cañari', '00012395678','998875223','sebastian@gmail.com', '10000001');*/

-- ConsultarCliente
drop procedure if exists ConsultarCliente;
delimiter @@
create procedure ConsultarCliente(id_cli int)
begin
	select * from cliente where id_cliente = id_cli;
end @@
delimiter ;
call ConsultarCliente('3');


-- EliminarCliente
drop procedure if exists EliminarCliente;
delimiter @@
create procedure EliminarCliente(id_cli int)
begin
	delete from cliente where id_cliente = id_cli;
end @@
delimiter ;
call EliminarCliente(3);

-- REGISTRO DEl EMPLEADO-----------------------------------------------------
-- ListarEmpleado
drop procedure if exists ListarEmpleado;
delimiter @@
create procedure ListarEmpleado()
begin
	select * from empleado;
end @@
delimiter ;
call ListarEmpleado();

-- AñadirEmpleado
drop procedure if exists AnadirEmpleado;
delimiter @@
create procedure AnadirEmpleado(id_em char(3), id_rol char(2), di_emp char(11), nom_em varchar(40), ape_em varchar(60), celular_em varchar(9), correo_em varchar(90))
begin
	insert into empleado values(id_em, id_rol, di_emp, nom_em, ape_em, celular_em, correo_em);
end @@
delimiter ;
/*call AnadirEmpleado('103','12', '00019311578', 'Carlos', 'Martel Cerca', '987611321', 'Carlos@gmail.com');*/

-- ModificarEmpleado
drop procedure if exists ModificarEmpleado;
delimiter @@
create procedure ModificarEmpleado(id_em char(3), id_rol char(2), di_emp char(11), nom_em varchar(40), ape_em varchar(60), celular_em varchar(9), correo_em varchar(90))
begin
	update empleado set  id_rol = id_rol, docIndentidad_emp=di_emp, nombre_emp=nom_em, apellido_emp=ape_em, celular_emp= celular_em, correo_emp=correo_em where id_emp = id_em;
end @@
delimiter ;
/*call ModificarEmpleado('103','12', '00019311578', 'Pedro', 'Martel Cerca', '987611321', 'Pedro@gmail.com');*/

-- ConsultarEmpleado
drop procedure if exists ConsultarEmpleado;
delimiter @@
create procedure ConsultarEmpleado(id_em char(3))
begin
	select * from empleado where id_emp = id_em;
end @@
delimiter ;
/*call ConsultarEmpleado('102');*/

-- EliminarEmpleado
drop procedure if exists EliminarEmpleado;
delimiter @@
create procedure EliminarEmpleado(id_em char(3))
begin
	delete from empleado where id_emp = id_em;
end @@
delimiter ;
/*call EliminarEmpleado('103');*/

select * from empleado;

-- -----------------------------------------------------------------------------
-- CONSULTA BUSCAR HABITACION
-- ------------------------------------------------------------------------------

drop procedure if exists ConsultaBuscarHabitacion;
delimiter @@
create procedure ConsultaBuscarHabitacion ()
begin
	select c.id_cliente as 'Cod_Ciente',
		     h.NumDias_hab as 'N°Dias',
             h.descripcion_hab as 'Descripción',
             h.tipo_hab as 'Tipo de Habitación',
             db.precioHab_dBoleta as 'Precio X Dia'
    from cliente AS c JOIN detalleboleta AS db ON  c.id_cliente= db.id_cliente 
					  JOIN habitacion AS h ON h.id_hab = db.id_hab ;
end @@
delimiter ;
call ConsultaBuscarHabitacion();

drop procedure if exists ConsultaBuscarHabitacionId;
delimiter @@
create procedure ConsultaBuscarHabitacionId (id char(4))
begin
	select c.id_cliente as 'Cod_Ciente',
		     h.NumDias_hab as 'N°Dias',
             h.descripcion_hab as 'Descripción',
             h.tipo_hab as 'Tipo de Habitación',
             db.precioHab_dBoleta as 'Precio X Dia'
    from cliente AS c JOIN detalleboleta AS db ON  c.id_cliente= db.id_cliente 
					  JOIN habitacion AS h ON h.id_hab = db.id_hab 
    where h.id_hab like (Concat(concat('%',id),'%')) ;
end @@
delimiter ;
/*call ConsultaBuscarHabitacionId('1112');*/


drop procedure if exists ConsultaBuscarHabitacionTipo;
delimiter @@
create procedure ConsultaBuscarHabitacionTipo (tipo char(1))
begin
	select c.id_cliente as 'Cod_Ciente',
		     h.NumDias_hab as 'N°Dias',
             h.descripcion_hab as 'Descripción',
             h.tipo_hab as 'Tipo de Habitación',
             db.precioHab_dBoleta as 'Precio X Dia'
    from cliente AS c JOIN detalleboleta AS db ON  c.id_cliente= db.id_cliente 
					  JOIN habitacion AS h ON h.id_hab = db.id_hab 
    where h.tipo_hab like (Concat(concat('%',tipo),'%')) ;
end @@
delimiter ;
/*call ConsultaBuscarHabitacionTipo('1');*/




-- -----------------------------------------------------------------------------
-- CONSULTA BUSCAR BOLETA
-- ------------------------------------------------------------------------------
drop procedure if exists ConsultaBuscarBoleta;
delimiter @@
create procedure ConsultaBuscarBoleta ()
begin
	select b.id_boleta as 'Cod_Boleta',
		     CONCAT (e.nombre_emp, ' ' , e.apellido_emp) AS 'Nombre Empleado',
             CONCAT (c.nombre_cliente, ' ' , c.apellido_cliente) AS 'Nombre Cliente',
             b.fecha_boleta as 'Fecha Boleta',
             b.ruc_boleta as 'Ruc Boleta',
             b.tipoPago_boleta as 'Tipo de pago',
             h.NumDias_hab as 'N°Dias',
             db.precioHab_dBoleta as 'Precio X Dia',
             (h.NumDias_hab * db.precioHab_dBoleta) as 'Precio Total'
    from cliente AS c JOIN detalleboleta AS db ON  c.id_cliente= db.id_cliente 
					  JOIN habitacion AS h ON h.id_hab = db.id_hab 
                      JOIN boleta AS b ON b.id_boleta = db.id_boleta
                      JOIN empleado AS e ON e.id_emp = b.id_emp
    ;
end @@
delimiter ;
call ConsultaBuscarBoleta();


drop procedure if exists ConsultaBuscarBoletaIdCliente;
delimiter @@
create procedure ConsultaBuscarBoletaIdCliente (cliente int)
begin
	select b.id_boleta as 'Cod_Boleta',
		     CONCAT (e.nombre_emp, ' ' , e.apellido_emp) AS 'Nombre Empleado',
             CONCAT (c.nombre_cliente, ' ' , c.apellido_cliente) AS 'Nombre Cliente',
             b.fecha_boleta as 'Fecha Boleta',
             b.ruc_boleta as 'Ruc Boleta',
             b.tipoPago_boleta as 'Tipo de pago',
             h.NumDias_hab as 'N°Dias',
             db.precioHab_dBoleta as 'Precio X Dia',
             (h.NumDias_hab * db.precioHab_dBoleta) as 'Precio Total'
    from cliente AS c JOIN detalleboleta AS db ON  c.id_cliente= db.id_cliente 
					  JOIN habitacion AS h ON h.id_hab = db.id_hab 
                      JOIN boleta AS b ON b.id_boleta = db.id_boleta
                      JOIN empleado AS e ON e.id_emp = b.id_emp
    where c.id_cliente like (Concat(concat('%',cliente),'%')) ;
end @@
delimiter ;
/*call ConsultaBuscarBoletaIdCliente(1);*/



drop procedure if exists ConsultaBuscarBoletaIdBoleta;
delimiter @@
create procedure ConsultaBuscarBoletaIdBoleta (boleta varchar(9))
begin
	select b.id_boleta as 'Cod_Boleta',
		     CONCAT (e.nombre_emp, ' ' , e.apellido_emp) AS 'Nombre Empleado',
             CONCAT (c.nombre_cliente, ' ' , c.apellido_cliente) AS 'Nombre Cliente',
             b.fecha_boleta as 'Fecha Boleta',
             b.ruc_boleta as 'Ruc Boleta',
             b.tipoPago_boleta as 'Tipo de pago',
             h.NumDias_hab as 'N°Dias',
             db.precioHab_dBoleta as 'Precio X Dia',
             (h.NumDias_hab * db.precioHab_dBoleta) as 'Precio Total'
    from cliente AS c JOIN detalleboleta AS db ON  c.id_cliente= db.id_cliente 
					  JOIN habitacion AS h ON h.id_hab = db.id_hab 
                      JOIN boleta AS b ON b.id_boleta = db.id_boleta
                      JOIN empleado AS e ON e.id_emp = b.id_emp
    where b.id_boleta like (Concat(concat('%',boleta),'%')) ;
end @@
delimiter ;
/*call ConsultaBuscarBoletaIdBoleta('9000');*/


/*Generar Codigo*/

drop procedure if exists GenerarCodigoDir;

delimiter @@
create procedure GenerarCodigoDir()
begin
SELECT CONCAT("DIR",LPAD(CONVERT(CONVERT(RIGHT(id_direccion,5),SIGNED INTEGER)+1,CHAR),5,'0')) as codigo
FROM direccion  ORDER BY 1 DESC LIMIT 0,1;
end @@
delimiter ;

call GenerarCodigoDir();


drop procedure if exists GenerarCodigoEmp;

delimiter @@
create procedure GenerarCodigoEmp()
begin
SELECT CONCAT("E",LPAD(CONVERT(CONVERT(RIGHT(id_emp,2),SIGNED INTEGER)+1,CHAR),2,'0')) as codigo
FROM empleado  ORDER BY 1 DESC LIMIT 0,1;
end @@
delimiter ;

call GenerarCodigoEmp();



drop procedure if exists GenerarCodigoHab;

delimiter @@
create procedure GenerarCodigoHab()
begin
SELECT CONCAT("H",LPAD(CONVERT(CONVERT(RIGHT(id_hab,3),SIGNED INTEGER)+1,CHAR),3,'0')) as codigo
FROM habitacion ORDER BY 1 DESC LIMIT 0,1;
end @@
delimiter ;

call GenerarCodigoHab();

drop procedure if exists GenerarCodigoCuenta;

delimiter @@
create procedure GenerarCodigoCuenta()
begin
SELECT CONCAT("CT",LPAD(CONVERT(CONVERT(RIGHT(id_cuenta,2),SIGNED INTEGER)+1,CHAR),2,'0')) as codigo
FROM cuenta ORDER BY 1 DESC LIMIT 0,1;
end @@
delimiter ;

call GenerarCodigoCuenta();


select * from cliente
