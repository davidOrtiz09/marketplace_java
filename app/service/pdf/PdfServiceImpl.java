package service.pdf;
import javax.inject.Inject;
import it.innove.play.pdf.PdfGenerator;
import play.twirl.api.Html;

public class PdfServiceImpl implements PdfService {
    @Inject
    private PdfGenerator pdfGenerator;

    public byte[] generatePdf(Html template){
        return pdfGenerator.toBytes(template, null);
    }
}
