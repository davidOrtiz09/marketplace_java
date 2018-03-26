package service.queue;

import com.google.inject.ImplementedBy;
import model.Producto;

import java.util.List;

@ImplementedBy(QueueServiceImpl.class)
public interface QueueService {

    public Long sendMessage(List<Producto> productos);
}
