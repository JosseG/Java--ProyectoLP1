

create database ReservaHotel;

create table direccion(
id_direccion char(4) primary key,
descripcion_direccion varchar(50) not null,
distrito_direccion varchar(30) not null
);

create table cliente(
id_cliente int primary key auto_increment,
nombre_cliente varchar(30) not null,
apellidoPat_cliente varchar(60) not null,
apellidoMat_cliente varchar(60) not null,
telefono_cliente varchar(9) not null,
correo_cliente varchar(90),
id_direccion char(4) not null,
foreign key(id_direccion) references direccion(id_direccion)
);

create table habitacion(
id_hab char(4) primary key,
disp_hab char(1)  not null,
descripcion_hab varchar(90) not null,
tipo_hab varchar(15) not null,
check( disp_hab='y' or disp_hab='n')
);


create table rol(
id_rol char(2) primary key not null,
nombre_rol varchar(15) not null
);

create table empleado(
id_emp char(3) primary key not null,
id_rol char(2) not null,
dni_emp char(6) not null,
nombre_emp varchar(40) not null,
apellidoPat_emp varchar(60) not null,
apellidoMat_emp varchar(60) not null,
telefono_emp varchar(9) not null,
correo_emp varchar(90) not null,
fecha_ingreso_emp date not null,
foreign key(id_rol) references rol(id_rol)
);

create table login(
id_login int primary key auto_increment,
id_emp char(3) not null,
username_login varchar(30) not null,
password_login varchar(30) not null,
foreign key(id_emp) references empleado(id_emp)
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
foreign key(id_cliente) references cliente(id_cliente),
foreign key(id_hab) references habitacion(id_hab),
primary key(id_boleta,id_cliente,id_hab)
);

use ReservaHotel;


drop database ReservaHotel;
