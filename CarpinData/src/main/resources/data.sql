-------------------------- INSERTAR DATOS EN Material --------------------------
INSERT IGNORE INTO Material (nombre, descripcion, costo, stock, fecha_ingreso, estado)
VALUES ('Tablón de pino', 'Madera de pino para muebles y estructuras', 120.00, 50, '2025-01-15', 'D');

INSERT IGNORE INTO Material (nombre, descripcion, costo, stock, fecha_ingreso, estado)
VALUES ('Listón de cedro', 'Madera de cedro ideal para acabados finos', 85.50, 100, '2025-02-10', 'D');

INSERT IGNORE INTO Material (nombre, descripcion, costo, stock, fecha_ingreso, estado)
VALUES ('Tablero MDF', 'Madera prensada MDF para carpintería y decoración', 150.75, 40, '2025-03-05', 'N');

INSERT IGNORE INTO Material (nombre, descripcion, costo, stock, fecha_ingreso, estado)
VALUES ('Contrachapado', 'Laminado de madera contrachapada resistente', 200.00, 75, '2025-04-20', 'D');

INSERT IGNORE INTO Material (nombre, descripcion, costo, stock, fecha_ingreso, estado)
VALUES ('Viga de roble', 'Vigas de roble macizo para estructuras pesadas', 300.00, 25, '2025-05-01', 'D');


-------------------------- INSERTAR DATOS EN Tipo --------------------------
INSERT IGNORE INTO Tipo (nombre, descripcion, estado)
VALUES ('Puerta', 'Puertas a medida de alta calidad', 'Activo')

INSERT IGNORE INTO Tipo (nombre, descripcion, estado)
VALUES ('Estanteria', 'Estanterias duraderas y de alta calidad', 'Activo')

INSERT IGNORE INTO Tipo (nombre, descripcion, estado)
VALUES ('Silla', 'Sillas que aguantan hasta a dos Ricardos', 'Activo')

INSERT IGNORE INTO Tipo (nombre, descripcion, estado)
VALUES ('Mesas', 'Mesas duraderas y bonitas', 'Activo')

INSERT IGNORE INTO Tipo (nombre, descripcion, estado)
VALUES ('Escaleras', 'Madera de pino de alta calidad', 'Activo')


-------------------------- INSERTAR DATOS EN Mueble --------------------------
INSERT IGNORE INTO Mueble (color, tamaño, estilo)
VALUES ('Rojo', 'Grande, 15x15m', 'Moderno');

INSERT IGNORE INTO Mueble (color, tamaño, estilo)
VALUES ('Azul', 'Mediano, 10x10m', 'Vintage');

INSERT IGNORE INTO Mueble (color, tamaño, estilo)
VALUES ('Verde', 'Pequeño, 5x5m', 'Clásico');

INSERT IGNORE INTO Mueble (color, tamaño, estilo)
VALUES ('Amarillo', 'Grande, 15x15m', 'Minimalista');

INSERT IGNORE INTO Mueble (color, tamaño, estilo)
VALUES ('Blanco', 'Mediano, 10x10m', 'Contemporáneo');


-------------------------- INSERTAR DATOS EN Categoria --------------------------
INSERT IGNORE INTO Categoria (nombre, descripcion, estado)
VALUES ('Muebles', 'Categoría para todo tipo de muebles', 'A');

INSERT IGNORE INTO Categoria (nombre, descripcion, estado)
VALUES ('Puertas', 'Categoría dedicada a puertas de madera y metálicas', 'A');

INSERT IGNORE INTO Categoria (nombre, descripcion, estado)
VALUES ('Estanterías', 'Categoría para estanterías de diferentes tamaños', 'A');

INSERT IGNORE INTO Categoria (nombre, descripcion, estado)
VALUES ('Mesas', 'Categoría especializada en mesas de comedor y escritorio', 'A');

INSERT IGNORE INTO Categoria (nombre, descripcion, estado)
VALUES ('Sillas', 'Categoría para sillas de oficina, comedor y descanso', 'A');


-------------------------- INSERTAR DATOS EN Cliente --------------------------
INSERT IGNORE INTO Clientes (nombre, apellido, telefono, genero, fecha_Nacimiento)
VALUES ('Carlos', 'Pérez', '555-1234', 'Masculino', '1985-05-12');

INSERT IGNORE INTO Clientes (nombre, apellido, telefono, genero, fecha_Nacimiento)
VALUES ('Laura', 'Gómez', '555-5678', 'Femenino', '1992-08-23');

INSERT IGNORE INTO Clientes (nombre, apellido, telefono, genero, fecha_Nacimiento)
VALUES ('José', 'Martínez', '555-8765', 'Masculino', '1978-11-30');

INSERT IGNORE INTO Clientes (nombre, apellido, telefono, genero, fecha_Nacimiento)
VALUES ('Ana', 'Rodríguez', '555-4321', 'Femenino', '2000-01-15');

INSERT IGNORE INTO Clientes (nombre, apellido, telefono, genero, fecha_Nacimiento)
VALUES ('David', 'López', '555-2468', 'Masculino', '1989-04-06');
