package service.producto;

import com.google.inject.ImplementedBy;
import model.Producto;

import java.util.List;
import java.util.concurrent.CompletionStage;

@ImplementedBy(ProductoServiceImpl.class)
public interface ProductoService {

    public CompletionStage<List<Producto>> getProductos();

}