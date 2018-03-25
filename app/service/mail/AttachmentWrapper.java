package service.mail;

import com.google.inject.ImplementedBy;

@ImplementedBy(AttachmentWrapperImpl.class)
public interface AttachmentWrapper {
    String getName();
    byte[] getData();
    String getMimeType();
}

