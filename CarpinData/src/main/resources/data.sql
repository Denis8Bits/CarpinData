-------------------------- INSERTAR DATOS EN Material --------------------------
INSERT IGNORE INTO Material (nombre, descripcion, costo, stock, fecha_ingreso, estado)
VALUES ('Tablón de pino', 'Madera de pino para muebles y estructuras', 120.00, 50, '2025-01-15', 'ACTIVE');

INSERT IGNORE INTO Material (nombre, descripcion, costo, stock, fecha_ingreso, estado)
VALUES ('Listón de cedro', 'Madera de cedro ideal para acabados finos', 85.50, 100, '2025-02-10', 'ACTIVE');

INSERT IGNORE INTO Material (nombre, descripcion, costo, stock, fecha_ingreso, estado)
VALUES ('Tablero MDF', 'Madera prensada MDF para carpintería y decoración', 150.75, 40, '2025-03-05', 'ACTIVE');

INSERT IGNORE INTO Material (nombre, descripcion, costo, stock, fecha_ingreso, estado)
VALUES ('Contrachapado', 'Laminado de madera contrachapada resistente', 200.00, 75, '2025-04-20', 'ACTIVE');

INSERT IGNORE INTO Material (nombre, descripcion, costo, stock, fecha_ingreso, estado)
VALUES ('Viga de roble', 'Vigas de roble macizo para estructuras pesadas', 300.00, 25, '2025-05-01', 'ACTIVE');


-------------------------- INSERTAR DATOS EN Tipo --------------------------
INSERT IGNORE INTO Tipo (nombre, descripcion, estado)
VALUES ('Puerta', 'Puertas a medida de alta calidad', 'ACTIVE');

INSERT IGNORE INTO Tipo (nombre, descripcion, estado)
VALUES ('Estanteria', 'Estanterias duraderas y de alta calidad', 'ACTIVE');

INSERT IGNORE INTO Tipo (nombre, descripcion, estado)
VALUES ('Silla', 'Sillas que aguantan hasta a dos Ricardos', 'ACTIVE');

INSERT IGNORE INTO Tipo (nombre, descripcion, estado)
VALUES ('Mesas', 'Mesas duraderas y bonitas', 'ACTIVE');

INSERT IGNORE INTO Tipo (nombre, descripcion, estado)
VALUES ('Escaleras', 'Madera de pino de alta calidad', 'ACTIVE');


-------------------------- INSERTAR DATOS EN Mueble --------------------------
INSERT IGNORE INTO Mueble (color, `tamaño`, estilo)
VALUES ('Rojo', 'Grande, 15x15m', 'Moderno');

INSERT IGNORE INTO Mueble (color, `tamaño`, estilo)
VALUES ('Azul', 'Mediano, 10x10m', 'Vintage');

INSERT IGNORE INTO Mueble (color, `tamaño`, estilo)
VALUES ('Verde', 'Pequeño, 5x5m', 'Clásico');

INSERT IGNORE INTO Mueble (color, `tamaño`, estilo)
VALUES ('Amarillo', 'Grande, 15x15m', 'Minimalista');

INSERT IGNORE INTO Mueble (color, `tamaño`, estilo)
VALUES ('Blanco', 'Mediano, 10x10m', 'Contemporáneo');


-------------------------- INSERTAR DATOS EN Categoria --------------------------
INSERT IGNORE INTO Categoria (nombre, descripcion, estado)
VALUES ('Muebles', 'Categoría para todo tipo de muebles', 'ACTIVE');

INSERT IGNORE INTO Categoria (nombre, descripcion, estado)
VALUES ('Puertas', 'Categoría dedicada a puertas de madera y metálicas', 'ACTIVE');

INSERT IGNORE INTO Categoria (nombre, descripcion, estado)
VALUES ('Estanterías', 'Categoría para estanterías de diferentes tamaños', 'ACTIVE');

INSERT IGNORE INTO Categoria (nombre, descripcion, estado)
VALUES ('Mesas', 'Categoría especializada en mesas de comedor y escritorio', 'ACTIVE');

INSERT IGNORE INTO Categoria (descripcion, nombre, estado)
VALUES ('Sillas', 'Categoría para sillas de oficina, comedor y descanso', 'ACTIVE');

-------------------------- INSERTAR DATOS EN Cotizacion --------------------------
INSERT IGNORE INTO Cotizacion (cantidad, total, descripcion)
VALUES (10, 1200.50, 'Cotización de tablones de pino para estructura de techo');

INSERT IGNORE INTO Cotizacion (cantidad, total, descripcion)
VALUES (5, 1500.75, 'Cotización de puertas de cedro macizo con acabado fino');

INSERT IGNORE INTO Cotizacion (cantidad, total, descripcion)
VALUES (20, 850.00, 'Cotización de sillas de madera estilo clásico');

INSERT IGNORE INTO Cotizacion (cantidad, total, descripcion)
VALUES (3, 3000.00, 'Cotización de mesas grandes de comedor en roble');

INSERT IGNORE INTO Cotizacion (cantidad, total, descripcion)
VALUES (12, 2200.25, 'Cotización de estanterías modulares MDF');


-------------------------- INSERTAR DATOS EN Reserva --------------------------
INSERT IGNORE INTO reserva (fecha_Reserva, estado, id_Usuario, id_Mueble)
VALUES ('2025-01-20', 'ACTIVA', 1, 1);

INSERT IGNORE INTO reserva (fecha_Reserva, estado, id_Usuario, id_Mueble)
VALUES ('2025-02-15', 'ACTIVA', 2, 3);

INSERT IGNORE INTO reserva (fecha_Reserva, estado, id_Usuario, id_Mueble)
VALUES ('2025-03-10', 'COMPLETADA', 3, 2);

INSERT IGNORE INTO reserva (fecha_Reserva, estado, id_Usuario, id_Mueble)
VALUES ('2025-04-05', 'CANCELADA', 4, 4);

INSERT IGNORE INTO reserva (fecha_Reserva, estado, id_Usuario, id_Mueble)
VALUES ('2025-05-12', 'ACTIVA', 5, 5);

INSERT IGNORE INTO reserva (fecha_Reserva, estado, id_Usuario, id_Mueble)
VALUES ('2025-06-18', 'PENDIENTE', 1, 2);

INSERT IGNORE INTO reserva (fecha_Reserva, estado, id_Usuario, id_Mueble)
VALUES ('2025-07-22', 'ACTIVA', 3, 4);

INSERT IGNORE INTO reserva (fecha_Reserva, estado, id_Usuario, id_Mueble)
VALUES ('2025-08-30', 'COMPLETADA', 2, 1);

