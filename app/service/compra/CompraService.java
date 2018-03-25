package service.compra;

import com.google.inject.ImplementedBy;
import model.Compra;

import java.util.concurrent.CompletionStage;

@ImplementedBy(CompraServiceImpl.class)
public interface CompraService {

    public CompletionStage<Compra> getCompraByUsuario(Long id);

    public CompletionStage<Long> completarCompra(Long id);

}