package service;

import dao.CompraDAO;
import model.Compra;
import javax.inject.Inject;
import java.util.concurrent.CompletionStage;

public class CompraServiceImpl implements CompraService {

    private final CompraDAO compraDAO;

    @Inject
    public CompraServiceImpl(CompraDAO compraDAO){
        this.compraDAO = compraDAO;
    }

    public CompletionStage<Compra> getCompraByUsuario(Long id) {

        return  compraDAO.getCompraByUsuario(id);
    }

    public CompletionStage<Long> completarCompra(Long id) {
        return compraDAO.getCompraByUsuario(id)
                .thenApplyAsync(compra -> new Compra(compra.id, compra.comprador, compra.productos, true))
                .thenComposeAsync( compra ->
                        compraDAO.update(id, compra));
    }

}
