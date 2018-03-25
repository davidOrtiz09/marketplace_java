package model;

import java.util.ArrayList;

public class Compra {

    public Id<Compra> id;
    public Usuario comprador;
    public ArrayList<Producto> productos;
    public Boolean estaCompleta;

    public Compra(Id<Compra> id, Usuario comprador, ArrayList<Producto> productos) {
        this.id = id;
        this.comprador = comprador;
        this.productos = productos;
        this.estaCompleta = false;
    }

    public Double getTotalCompra() {
        Double total = 0D;
        for(Producto producto : productos) {
            total += producto.precio;
        }
        return total;
    }

    public void completarCompra() {
        this.estaCompleta = true;
    }
}
