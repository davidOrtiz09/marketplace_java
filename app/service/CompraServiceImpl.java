package service;

import dao.config.CompraDAO;
import model.Compra;
import model.Id;
import model.Usuario;

import javax.inject.Inject;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

public class CompraServiceImpl implements CompraService {

    private final CompraDAO compraDAO;

    @Inject
    public CompraServiceImpl(CompraDAO compraDAO){
        this.compraDAO = compraDAO;
    }

    public CompletionStage<Compra> getCompraByUsuario(Id<Usuario> id) {

        return  compraDAO.getCompraByUsuario(id);
    }

}
