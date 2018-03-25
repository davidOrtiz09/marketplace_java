package dao;

import io.ebean.Ebean;
import io.ebean.EbeanServer;
import io.ebean.Transaction;
import model.Compra;
import model.Producto;
import play.db.ebean.EbeanConfig;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletionStage;
import static java.util.concurrent.CompletableFuture.supplyAsync;

public class ProductoDAO {
    private final EbeanServer ebeanServer;
    private final DatabaseExecutionContext executionContext;

    @Inject
    public ProductoDAO(DatabaseExecutionContext executionContext, EbeanConfig ebeanConfig){

        this.ebeanServer = Ebean.getServer(ebeanConfig.defaultServer());
        this.executionContext = executionContext;
    }

    public CompletionStage<List<Producto>> getProductos(){
        return supplyAsync(() -> {
            return ebeanServer.find(Producto.class).findList();
        }, executionContext);
    }
}
