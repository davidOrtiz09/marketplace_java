package service.queue;

import com.google.inject.ImplementedBy;

@ImplementedBy(QueueServiceImpl.class)
public interface QueueService {

    public void sendMessage(String message);
}