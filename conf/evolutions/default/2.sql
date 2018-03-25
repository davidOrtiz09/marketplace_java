# Marketplace schema inserts

# === !Ups
INSERT INTO productos (id,descripcion,precio) VALUES(1,'lampara', 25000);
INSERT INTO productos (id,descripcion,precio) VALUES(2,'bombillo', 4200);
INSERT INTO productos (id,descripcion,precio) VALUES(3,'lampara rustica', 60000);
INSERT INTO productos (id,descripcion,precio) VALUES(4,'lampara moderna', 80000);

INSERT INTO usuarios(id,nombre,apellido) VALUES(1,'david', 'ortiz');
INSERT INTO usuarios(id,nombre,apellido) VALUES(2,'pepito', 'perez');

INSERT INTO compras(id,id_comprador,esta_completa) VALUES(1, 1, false);
INSERT INTO compras(id,id_comprador,esta_completa) VALUES(2, 2, false);

INSERT INTO compras_de_productos(id_compra,id_producto) values(1,1);
INSERT INTO compras_de_productos(id_compra,id_producto) values(1,2);
INSERT INTO compras_de_productos(id_compra,id_producto) values(2,3);
INSERT INTO compras_de_productos(id_compra,id_producto) values(2,4);

# === !Downs
DELETE FROM compras_de_productos;
DELETE FROM compras;
DELETE FROM usuarios;
DELETE FROM productos;