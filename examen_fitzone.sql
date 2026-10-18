CREATE TABLE socios (
    id_socio INT PRIMARY KEY,
    nombres VARCHAR(50) NOT NULL,
    apellidos VARCHAR(50) NOT NULL,
    edad INT NOT NULL,
    fecha_registro VARCHAR(10) NOT NULL,
    activo BOOLEAN NOT NULL
);

INSERT INTO socios (id_socio, nombres, apellidos, edad, fecha_registro, activo)
VALUES
(1, 'Carlos', 'Perez', 25, '2026-01-15', true),
(2, 'Maria', 'Lopez', 17, '2026-02-10', true),
(3, 'Juan', 'Gomez', 32, '2026-03-20', false),
(4, 'Ana', 'Torres', 20, '2026-05-12', true),
(5, 'Luis', 'Mendoza', 16, '2026-08-25', true);

SELECT * FROM  socios;

-- Consulta 1
SELECT nombres, apellidos, edad
FROM socios
WHERE activo = true AND edad > 18;

-- Consulta 2
SELECT *
FROM socios
WHERE fecha_registro > '2026-02-01';

-- Consulta 3
SELECT *
FROM socios
ORDER BY edad DESC;

-- Añadir nueva columna email
ALTER TABLE socios
ADD COLUMN email VARCHAR(100);

-- Asignar correo a un socio mediante su id 
UPDATE socios
SET email = 'carlos.perez@gmail.com'
WHERE id_socio = 1;

SELECT * FROM socios;