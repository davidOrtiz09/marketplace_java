package model;

public class Producto {

    public Producto(Id<Producto> id, String descripcion, Double precio){
        this.id = id;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public Id<Producto> id ;
    public String descripcion;
    public Double precio;
}
