# Marketplace schema creation

# === !Ups
create table "usuarios" ("id" SERIAL NOT NULL PRIMARY KEY,"nombre" VARCHAR NOT NULL ,"apellido" VARCHAR NOT NULL);

create table "productos" ("id" SERIAL NOT NULL PRIMARY KEY,
"descripcion" VARCHAR NOT NULL,
"precio" numeric(21,8) NOT NULL);

create table "compras" ("id" SERIAL NOT NULL PRIMARY KEY,
"id_comprador" INTEGER NOT NULL,
"esta_completa" boolean NOT NULL);

create table "compras_de_productos" ("id" SERIAL NOT NULL PRIMARY KEY,
"id_compra" INTEGER NOT NULL,
"id_producto" INTEGER NOT NULL);

# === !Downs
DROP TABLE "compras_de_productos";
DROP TABLE "compras";
DROP TABLE "productos";
DROP TABLE "usuarios";