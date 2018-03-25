package controllers;

import play.libs.concurrent.HttpExecutionContext;
import play.mvc.*;
import service.CompraService;
import javax.inject.Inject;
import java.util.concurrent.CompletionStage;

public class Application extends Controller {

    private final CompraService compraService;
    private final HttpExecutionContext httpExecutionContext;

    @Inject
    public Application(CompraService compraService, HttpExecutionContext httpExecutionContext){

        this.compraService = compraService;
        this.httpExecutionContext = httpExecutionContext;
    }

   public CompletionStage<Result> completarCompra(Long idCompraa) {
        return compraService.completarCompra(idCompraa).thenApplyAsync(answer -> {
            return ok(views.html.compraExitosa.render());
        },  httpExecutionContext.current());
    }

    public CompletionStage<Result> mostrarCompra(Long idUsuario) {
            return compraService.getCompraByUsuario(idUsuario).thenApplyAsync(answer -> {
             return ok(views.html.mostrarCompra.render(answer));
            },  httpExecutionContext.current());
    }

    public Result index() {

        return ok(views.html.index.render("Your new application is ready."));
    }

}
