package dao.config;

import io.ebean.Ebean;
import io.ebean.EbeanServer;
import model.Compra;
import model.Id;
import model.Usuario;
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


    public CompletionStage<Compra> getCompraByUsuario(Id<Usuario> id) {

        return supplyAsync(() ->
                ebeanServer.find(Compra.class).setId(1L).findUnique()
        , executionContext);

    }
}
