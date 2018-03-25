package dao;

import io.ebean.Ebean;
import io.ebean.EbeanServer;
import io.ebean.Transaction;
import model.Compra;
import play.db.ebean.EbeanConfig;

import javax.inject.Inject;
import java.util.concurrent.CompletionStage;

import static java.util.concurrent.CompletableFuture.supplyAsync;


public class CompraDAO {

    private final EbeanServer ebeanServer;
    private final DatabaseExecutionContext executionContext;

    @Inject
    public CompraDAO(DatabaseExecutionContext executionContext, EbeanConfig ebeanConfig){

        this.ebeanServer = Ebean.getServer(ebeanConfig.defaultServer());
        this.executionContext = executionContext;
    }

    public CompletionStage<Compra> getCompraByUsuario(Long id) {

        return supplyAsync(() ->
                ebeanServer.find(Compra.class).setId(id).findUnique()
        , executionContext);

    }

    public CompletionStage<Long> update(Long id, Compra nuevaCompra) {

        Transaction txn = ebeanServer.beginTransaction();

        return supplyAsync(() -> {
                    try {
                        Compra compraActual = ebeanServer.find(Compra.class).setId(id).findUnique();
                        if (compraActual != null) {
                            compraActual.comprador = nuevaCompra.comprador;
                            compraActual.estaCompleta = nuevaCompra.estaCompleta;
                            compraActual.productos = nuevaCompra.productos;

                            compraActual.update();
                            txn.commit();
                        }
                    } finally {
                        txn.end();
                    }
                    return id;
                }
                , executionContext);

    }
}
