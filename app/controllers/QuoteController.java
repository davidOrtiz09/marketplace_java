package controllers;

import service.mail.AttachmentWrapperImpl;
import service.mail.AttachmentWrapper;
import play.mvc.Controller;
import play.mvc.Result;
import service.mail.MailService;
import service.pdf.PdfService;

import javax.inject.Inject;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class QuoteController extends Controller {

    @Inject
    private MailService mailService;

    @Inject
    private PdfService pdfService;

    public Result requestQuote(){
        return ok(views.html.quotes.requestQuote.render());
    }

    public Result sendQuote() {
        String[] recipients = {"jc.tangarife1927@gmail.com"};

        byte[] pdfBytes = pdfService.generatePdf(views.html.pdfs.test_pdf.render());

        AttachmentWrapper[] attachments = {new AttachmentWrapperImpl("quote.pdf", pdfBytes, "application/pdf")};

        mailService.sendEmail("Cotización Construmarket", recipients, views.html.emails.test_email.render().body(), attachments);
        return ok(views.html.quotes.quoteSended.render());
    }

}
