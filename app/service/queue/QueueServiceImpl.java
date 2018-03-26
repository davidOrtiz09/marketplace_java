package service.queue;



import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.sqs.AmazonSQSAsync;
import com.amazonaws.services.sqs.AmazonSQSAsyncClientBuilder;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import com.amazonaws.services.sqs.model.SendMessageResult;
import model.Producto;

import java.util.List;


public class QueueServiceImpl implements QueueService {

    private String queueUrl = "marketplace_grupo4";
    private String sqsUrl = "https://sqs.us-east-1.amazonaws.com/803611297537/marketplace_grupo4";
    private String sqsRegion = "us-east-1";


     private AmazonSQSAsync sqsClient = AmazonSQSAsyncClientBuilder
            .standard()
            .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(sqsUrl, sqsRegion))
            .build();


    public Long sendMessage(List<Producto> productos) {
        StringBuilder message = new StringBuilder();
        for(Producto producto: productos){
            message.append(producto.id.toString()).append("-");
        }
        SendMessageResult result = sqsClient.sendMessage(new SendMessageRequest(sqsUrl, message.toString()));
        return 1L;
    }


}