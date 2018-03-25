package service.mail;

import com.google.inject.ImplementedBy;

@ImplementedBy(MailServiceImpl.class)
public interface MailService {

    void sendEmail(String subject, String[] recipients, String body, AttachmentWrapper[] attachments);

}

