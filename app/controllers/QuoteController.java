package controllers;

import model.Producto;
import play.libs.concurrent.HttpExecutionContext;
import scala.collection.JavaConverters;
import scala.collection.Seq;
import service.mail.AttachmentWrapperImpl;
import service.mail.AttachmentWrapper;
import play.mvc.Controller;
import play.mvc.Result;
import service.mail.MailService;
import service.pdf.PdfService;
import play.data.DynamicForm;
import play.data.FormFactory;
import service.producto.ProductoService;

import javax.inject.Inject;
import java.util.concurrent.CompletionStage;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class QuoteController extends Controller {

    @Inject
    private MailService mailService;

    @Inject
    private PdfService pdfService;

    @Inject
    private FormFactory formFactory;

    @Inject
    private ProductoService productoService;

    @Inject
    private HttpExecutionContext httpExecutionContext;

    public Result requestQuote(){
        return ok(views.html.quotes.requestQuote.render());
    }

    public CompletionStage<Result> sendQuote() {
        DynamicForm dynamicForm = formFactory.form().bindFromRequest();
        String recipient = dynamicForm.get("email");
        String[] recipients = {recipient};

        return productoService.getProductos().thenApplyAsync(productos -> {
            Seq<Producto> productoSeq = JavaConverters.asScalaIteratorConverter(productos.iterator()).asScala().toSeq();
            byte[] pdfBytes = pdfService.generatePdf(views.html.pdfs.test_pdf.render(productoSeq));

            AttachmentWrapper[] attachments = {new AttachmentWrapperImpl("quote.pdf", pdfBytes, "application/pdf")};

            mailService.sendEmail("Cotización Construmarket", recipients, views.html.emails.test_email.render().body(), attachments);
            return ok(views.html.quotes.quoteSended.render());
        }, httpExecutionContext.current());

    }

}
