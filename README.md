-- LISTAR / TIPO:
localhost:8090/CarpinData/api/v1/tipos
localhost:8090/CarpinData/api/v1/tipos/1
localhost:8090/CarpinData/api/v1/tipos/2
localhost:8090/CarpinData/api/v1/tipos/3
localhost:8090/CarpinData/api/v1/tipos/4
localhost:8090/CarpinData/api/v1/tipos/5

-- MODIFICAR / TIPO :
localhost:8090/CarpinData/api/v1/tipos/id del tipo
 {
        "nombre": "Puerta",
        "descripcion": "Puertas a medida de alta calidad",
        "estado": "ACTIVE"
}

-- INSERTAR / TIPO :
localhost:8090/CarpinData/api/v1/tipos
{
        "nombre": " Escritorio ",
        "descripcion": " Escritorio para la sala ",
        "estado": "ACTIVE "
    }

-- ELIMINAR / TIPO :
localhost:8090/CarpinData/api/v1/tipos/id del tipo a eliminar

------------------------------------------------------- CATEGORIAS -----------------------------------------------------

-- LISTAR / CATEGORIAS: 
localhost:8090/CarpinData/api/v1/categorias
localhost:8090/CarpinData/api/v1/categorias/1
localhost:8090/CarpinData/api/v1/categorias/2
localhost:8090/CarpinData/api/v1/categorias/3
localhost:8090/CarpinData/api/v1/categorias/4
localhost:8090/CarpinData/api/v1/categorias/5
localhost:8090/CarpinData/api/v1/categorias/6

-- MODIFICAR / CATEGORIAS:
localhost:8090/CarpinData/api/v1/categorias/id de la categoria
{
        "nombre": "Puerta",
        "descripcion": "Categoría dedicada",
        "estado": "ACTIVE"
    }

-- INSERTAR / CATEGORIAS:
localhost:8090/CarpinData/api/v1/categorias
{
        "nombre": "VV",
        "descripcion": "Categoría dedicada a puertas de madera y metálicas",
        "estado": "ACTIVE"
    }

-- ELIMINAR / CATEGORIAAS:
localhost:8090/CarpinData/api/v1/categorias/id de la categoria a eliminar


------------------------------------------------------- MUEBLES -----------------------------------------------------
-- LISTAR / MUEBLES
localhost:8090/CarpinData/api/v1/muebles
localhost:8090/CarpinData/api/v1/muebles/1
localhost:8090/CarpinData/api/v1/muebles/2
localhost:8090/CarpinData/api/v1/muebles/3
localhost:8090/CarpinData/api/v1/muebles/4
localhost:8090/CarpinData/api/v1/muebles/5

-- MODIFICAR / MUEBLES
localhost:8090/CarpinData/api/v1/muebles/id del mueble
{
        "color": "rojo",
        "tamaño": "Grande, 15x15m",
        "estilo": "Vintage"
}
-- INSERTAR / MUEBLE
localhost:8090/CarpinData/api/v1/muebles
{
        "color": "Azul Marino",
        "tamaño": "Mediano, 10x10m",
        "estilo": "Moderno"
    }


-- ELIMINAR / MUEBLE:
localhost:8090/CarpinData/api/v1/muebles/id del mueble a eliminar

------------------------------------------------------- MATERIAL -----------------------------------------------------
-- LISTAR / MATERIAL:
localhost:8090/CarpinData/api/v1/materiales
localhost:8090/CarpinData/api/v1/materiales/1
localhost:8090/CarpinData/api/v1/materiales/2
localhost:8090/CarpinData/api/v1/materiales/3
localhost:8090/CarpinData/api/v1/materiales/4
localhost:8090/CarpinData/api/v1/materiales/5

-- MODIFICAR / MATERIAL
localhost:8090/CarpinData/api/v1/materiales/id del material
{
        "nombre": "Tablón de pino",
        "descripcion": "Madera de pino para muebles y estructuras",
        "costo": 120.00,
        "stock": 50,
        "fechaIngreso": "2025-01-15",
        "estado": "A"
}

-- INSERTAR / MATERIAL:
localhost:8090/CarpinData/api/v1/materiales
{

        "nombre": "Tablón",
        "descripcion": "Madera de pino para muebles y estructuras",
        "costo": 120.00,
        "stock": 50,
        "fechaIngreso": "2025-01-15",
        "estado": "A"
    }


-- ELIMINAR / MATERIAL: 
localhost:8090/CarpinData/api/v1/materiales/id del material que elimine
