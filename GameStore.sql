DROP DATABASE IF EXISTS GameStore;
CREATE DATABASE IF NOT EXISTS GameStore;

USE GameStore;
 -- CREACION DE LAS TABLAS
CREATE TABLE videojuegos(
 id_videojuego INT AUTO_INCREMENT PRIMARY KEY,
titulo VARCHAR(100) NOT NULL,
genero VARCHAR(50),
precio DECIMAL (10,2),
fecha_lanzamiento DATE,
plataforma VARCHAR (50),
puntuacion DECIMAL (3,1)
);
CREATE TABLE usuarios(
id_usuario INT AUTO_INCREMENT PRIMARY KEY,
nombre VARCHAR (50) NOT NULL,
email VARCHAR(50) NOT NULL UNIQUE,
fecha_registro DATE,
saldo DECIMAL(10,2)
);

CREATE TABLE ventas(
id_venta INT AUTO_INCREMENT PRIMARY KEY,
id_usuario INT,
id_videojuego INT,
FOREIGN KEY (id_usuario)REFERENCES Usuarios(id_usuario),
FOREIGN KEY (id_videojuego)REFERENCES Videojuegos(id_videojuego),
fecha_compra DATE 
);
-- MODIFICACIONES DE LA ESTRUCTURA DE LA TABLA
ALTER TABLE videojuegos
MODIFY precio DECIMAL(10,2)NOT NULL;

ALTER TABLE videojuegos
ADD  COLUMN descuento DECIMAL(5,2);

ALTER TABLE videojuegos
CHANGE puntuacion valoracion DECIMAL(3,1);

ALTER TABLE videojuegos
DROP plataforma;

SELECT * FROM videojuegos;
-- INSERTS DE DATOS DE LAS TABLAS.

INSERT INTO videojuegos (titulo, genero, precio, fecha_lanzamiento, valoracion) VALUES
('The Witcher 3', 'RPG', 39.99, '2015-05-19', 9.5),
('Cyberpunk 2077', 'RPG', 59.99, '2020-12-10', 8.3),
('Elden Ring', 'Acción', 49.99, '2022-02-25', 9.7),
('Minecraft', 'Sandbox', 29.99, '2011-11-18', 9.0),
('FIFA 23', 'Deportes', 69.99, '2022-09-30', 7.5);

INSERT INTO usuarios (nombre, email, fecha_registro, saldo) VALUES
('Carlos Gómez', 'carlos@gmail.com', '2023-01-15', 100.00),
('Ana Pérez', 'ana@gmail.com', '2022-08-20', 50.00),
('David Torres', 'david@gmail.com', '2021-05-10', 150.00),
('Laura Díaz', 'laura@gmail.com', '2020-11-05', 200.00);

INSERT INTO ventas (id_usuario, id_videojuego, fecha_compra) VALUES
(1, 3, '2023-02-10'),
(2, 1, '2022-09-01'),
(3, 2, '2021-06-15'),
(4, 5, '2023-07-05');
SELECT * FROM videojuegos;
SELECT *FROM usuarios;
SELECT *FROM ventas;

-- MODIFICACIONES DE LOS INSERTS.
SELECT  * FROM videojuegos;

UPDATE videojuegos
SET precio=precio *1.10
WHERE genero='RPG';


UPDATE videojuegos
SET titulo='Cyberpunk2077: UltimateEdition'
WHERE titulo= 'Cyberpunk 2077';

UPDATE videojuegos
SET fecha_lanzamiento ='2023-05-20'
WHERE titulo = 'Elden Ring';

SELECT * FROM videojuegos;

SELECT * FROM usuarios;
UPDATE usuarios
SET saldo=saldo+20
WHERE YEAR(fecha_registro)='2022';

SELECT * FROM usuarios;

-- 1. Contar el número total de videojuegos en la tienda.

SELECT COUNT(id_videojuego) AS videojuegos_totales FROM videojuegos;

-- 2. Obtener el precio promedio de todos los videojuegos.

SELECT AVG(precio) AS media_total FROM videojuegos;

-- 3. Determinar el precio más alto y el más bajo registrados.
SELECT MAX(precio) AS precio_maximo,MIN(precio) AS  precio_minimo FROM videojuegos;

-- 4. Mostrar el título del videojuego con el precio más alto.
SELECT titulo AS juego_mas_caro FROM videojuegos
WHERE precio IN (SELECT MAX(precio)FROM videojuegos);

-- 5. Contar cuántos videojuegos tienen una valoración superior a 9.

SELECT COUNT(id_videojuego)AS juegos_nota_alta FROM videojuegos
WHERE valoracion > 9;

-- 6.Obtener la suma total de los precios de todos los videojuegos.

SELECT SUM(precio) AS suma_total FROM videojuegos;

-- 7.Contar cuántos videojuegos tienen un precio superior a 50 euros.
SELECT COUNT(id_videojuego)AS mayor_cincuenta FROM videojuegos
WHERE precio >50;

-- 8.Mostrar el precio promedio de los videojuegos del género "Acción".

SELECT AVG(precio) AS promedio_accion FROM videojuegos
WHERE genero ='Acción';

-- 9.Obtener el número total de usuarios registrados.
 SELECT COUNT(id_usuario) AS usuario_total FROM usuarios;
 
 -- 10. Mostrar la fecha de registro más reciente y más antigua de los usuarios.

SELECT fecha_registro FROM usuarios 
WHERE ;

