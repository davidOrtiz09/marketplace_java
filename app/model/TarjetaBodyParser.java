package model;

import akka.util.ByteString;
import com.fasterxml.jackson.databind.JsonNode;
import play.libs.F;
import play.libs.streams.Accumulator;
import play.mvc.BodyParser;
import play.mvc.Http;
import play.mvc.Result;
import play.mvc.Results;

import javax.inject.Inject;
import java.util.concurrent.Executor;

public class TarjetaBodyParser implements BodyParser<Tarjeta> {

    private BodyParser.Json jsonParser;
    private Executor executor;

    @Inject
    public TarjetaBodyParser(BodyParser.Json jsonParser, Executor executor) {
        this.jsonParser = jsonParser;
        this.executor = executor;
    }

    @Override
    public Accumulator<ByteString, F.Either<Result, Tarjeta>> apply(Http.RequestHeader request) {
        Accumulator<ByteString, F.Either<Result, JsonNode>> jsonAccumulator = jsonParser.apply(request);
        return jsonAccumulator.map(resultOrJson -> {
            if (resultOrJson.left.isPresent()) {
                return F.Either.Left(resultOrJson.left.get());
            } else {
                JsonNode json = resultOrJson.right.get();
                try {
                    Tarjeta tarjeta = play.libs.Json.fromJson(json, Tarjeta.class);
                    return F.Either.Right(tarjeta);
                } catch (Exception e) {
                    return F.Either.Left(Results.badRequest(
                            "Unable to read Producto from json: " + e.getMessage()));
                }
            }
        }, executor);
    }

}