package service.compra;

import dao.CompraDAO;
import model.Compra;
import service.queue.QueueService;

import javax.inject.Inject;
import java.util.concurrent.CompletionStage;

public class CompraServiceImpl implements CompraService {

    private final CompraDAO compraDAO;
    private final QueueService queueService;

    @Inject
    public CompraServiceImpl(CompraDAO compraDAO, QueueService queueService){
        this.compraDAO = compraDAO;
        this.queueService = queueService;
    }

    public CompletionStage<Compra> getCompraByUsuario(Long idComprador) {

        return  compraDAO.getCompraByComprador(idComprador);
    }

    public CompletionStage<Long> completarCompra(Long id) {
        return compraDAO.getCompraById(id)
                .thenApplyAsync(compra -> new Compra(compra.id, compra.comprador, compra.productos, true))
                .thenComposeAsync( compra ->
                        compraDAO.update(id, compra)).
                        thenComposeAsync(compraDAO::getCompraById).
                        thenApply(compra -> queueService.sendMessage(compra.productos));

    }

}
