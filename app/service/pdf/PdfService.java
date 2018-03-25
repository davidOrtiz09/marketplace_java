package service.pdf;

import com.google.inject.ImplementedBy;
import play.twirl.api.Html;
import service.mail.AttachmentWrapperImpl;

@ImplementedBy(PdfServiceImpl.class)
public interface PdfService {
    byte[] generatePdf(Html template);
}

