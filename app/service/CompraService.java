package service;

import com.google.inject.ImplementedBy;
import model.Compra;
import model.Id;
import model.Usuario;

import java.util.concurrent.CompletionStage;

@ImplementedBy(CompraServiceImpl.class)
public interface CompraService {

    public CompletionStage<Compra> getCompraByUsuario(Id<Usuario> id);

}

