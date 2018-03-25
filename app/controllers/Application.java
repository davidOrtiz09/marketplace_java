package controllers;

import model.Id;
import model.Usuario;
import play.*;
import play.libs.concurrent.HttpExecutionContext;
import play.mvc.*;

import service.CompraService;
import views.html.*;

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

    public CompletionStage<Result> completarCompra(Long idCompraPlana) {
        Id<Usuario> idUsuario = new Id<>(idCompraPlana);
        return compraService.getCompraByUsuario(idUsuario).thenApplyAsync(answer -> {
            return ok(views.html.mostrarCompra.render(answer));
        },  httpExecutionContext.current());
    }

    public CompletionStage<Result> mostrarCompra(Long idUsuarioPlano) {
        Id<Usuario> idUsuario = new Id<>(idUsuarioPlano);
            return compraService.getCompraByUsuario(idUsuario).thenApplyAsync(answer -> {
             return ok(views.html.mostrarCompra.render(answer));
            },  httpExecutionContext.current());
    }

    public Result index() {

        return ok(views.html.index.render("Your new application is ready."));
    }

}
