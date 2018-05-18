package controllers;

import model.Tarjeta;
import model.TarjetaBodyParser;
import play.libs.concurrent.HttpExecutionContext;
import play.mvc.*;
import service.compra.CompraService;
import service.queue.QueueService;

import javax.inject.Inject;
import java.util.concurrent.CompletionStage;

public class Application extends Controller {

    private final CompraService compraService;
    private final HttpExecutionContext httpExecutionContext;
    private final QueueService queueService;

    @Inject
    public Application(CompraService compraService, HttpExecutionContext httpExecutionContext, QueueService queueService) {
        this.compraService = compraService;
        this.httpExecutionContext = httpExecutionContext;
        this.queueService = queueService;
    }

    public CompletionStage<Result> completarCompra(Long idCompra) {
        return compraService.completarCompra(idCompra).thenApplyAsync(answer -> {
            return ok(views.html.compraExitosa.render(idCompra));
        }, httpExecutionContext.current());
    }

    public CompletionStage<Result> mostrarCompra(Long idUsuario) {
        return compraService.getCompraByUsuario(idUsuario).thenApplyAsync(answer -> {
            return ok(views.html.mostrarCompra.render(answer));
        }, httpExecutionContext.current());
    }

    public Result index() {
        //queueService.sendMessage("TEST");
        return ok(views.html.index.render("Your new application is ready."));
    }

    @BodyParser.Of(TarjetaBodyParser.class)
    public Result recibirTarjeta() {
        Http.RequestBody body = request().body();
        Tarjeta tarjeta = body.as(Tarjeta.class);
        return ok("Tarjeta agregado correctamente");
    }

}
