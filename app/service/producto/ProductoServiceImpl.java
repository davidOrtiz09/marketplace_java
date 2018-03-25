package service.producto;

import dao.ProductoDAO;
import model.Producto;

import javax.inject.Inject;
import java.util.List;
import java.util.concurrent.CompletionStage;

public class ProductoServiceImpl implements ProductoService {

    private final ProductoDAO productoDAO;

    @Inject
    public ProductoServiceImpl(ProductoDAO productoDAO){
        this.productoDAO = productoDAO;
    }

    public CompletionStage<List<Producto>> getProductos(){
        return productoDAO.getProductos();
    }

}
