-- Base de datos
create database if not exists disenio_tp06;
use disenio_tp06;

-- Tipo Articulo
drop table if exists TipoArticulo;
create table TipoArticulo (
    codigo int not null auto_increment,
    nombre varchar(250) default null,
    primary key (codigo)
);

lock tables TipoArticulo write;
insert into TipoArticulo (nombre) values ('Limpieza');
insert into TipoArticulo (nombre) values ('Vestimenta');
insert into TipoArticulo (nombre) values ('Comestible');
unlock tables;

-- Marca
drop table if exists Marca;
create table Marca (
    codigo int not null auto_increment,
    nombre varchar(250) default null,
    primary key (codigo)
);


lock tables Marca write;
insert into Marca (nombre) values ('Adidas');
insert into Marca (nombre) values ('VEA');
insert into Marca (nombre) values ('TheVerdulery');
unlock tables;

-- Aticulo
drop table if exists Articulo;
create table Articulo (
    codigo int not null auto_increment,
    nombre varchar(250) default null,
    cantidad_pallet int default null,
    habilitar boolean default 1,
    codigo_tipoarticulo int not null,
    codigo_marca int not null,
    primary key (codigo),
    foreign key (codigo_tipoarticulo) references TipoArticulo (codigo),
    foreign key (codigo_marca) references Marca(codigo)
);

lock tables Articulo write;
insert into Articulo (nombre, cantidad_pallet, codigo_tipoarticulo, codigo_marca) values ('Pantuflas', 345, 2, 1);
insert into Articulo (nombre, cantidad_pallet, codigo_tipoarticulo, codigo_marca) values ('Cebolla', 500, 3, 3);
insert into Articulo (nombre, cantidad_pallet, codigo_tipoarticulo, codigo_marca) values ('Mata moscas', 40, 1, 2);
insert into Articulo (nombre, cantidad_pallet, codigo_tipoarticulo, codigo_marca) values ('Lavandina', 30, 1, 2);
insert into Articulo (nombre, cantidad_pallet, codigo_tipoarticulo, codigo_marca) values ('Yerba mate', 30, 3, 1);
unlock tables;
