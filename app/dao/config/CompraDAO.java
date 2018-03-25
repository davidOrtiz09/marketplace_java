package dao.config;

import model.Compra;
import model.Id;
import model.Producto;
import model.Usuario;

import javax.inject.Inject;
import java.util.ArrayList;

public class CompraDAO {

    private final DatabaseExecutionContext executionContext;

    @Inject
    public CompraDAO(DatabaseExecutionContext executionContext){
        this.executionContext = executionContext;
    }

    Id<Compra> idCompra = new Id<>(1L);
    Id<Usuario> idusuario = new Id<>(20L);
    Id<Producto> idProducto1 = new Id<>(31L);
    Id<Producto> idProducto2 = new Id<>(32L);

    String nombre = "David";
    String apellido = "Ortiz";
    Usuario usuario = new Usuario(idusuario, nombre, apellido);

    Producto producto1 = new Producto(idProducto1, "bombillo", 5000D);
    Producto producto2 = new Producto(idProducto2, "lampara", 45000D);


    public Compra getCompraByUsuario(Id<Usuario> id) {

        ArrayList<Producto> productos = new ArrayList<>();
        productos.add(producto1);
        productos.add(producto2);

        return new Compra(idCompra, usuario, productos);
    }
}
