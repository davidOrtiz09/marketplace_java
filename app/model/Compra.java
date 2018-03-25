package model;

import io.ebean.Finder;
import play.data.validation.Constraints;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "compras")
public class Compra extends BaseModel{

    @ManyToOne
    @JoinColumn(name="id_comprador")
    public Usuario comprador;


    @ManyToMany
    @JoinTable(name="compras_de_productos",
            joinColumns=@JoinColumn(name="id_compra", referencedColumnName="id"),
            inverseJoinColumns=@JoinColumn(name="id_producto", referencedColumnName="id"))
    public List<Producto> productos;

    @Constraints.Required
    public Boolean estaCompleta;


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

    public static final Finder<Long, Compra> find = new Finder<>(Compra.class);

}
