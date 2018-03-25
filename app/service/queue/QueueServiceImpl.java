package service.queue;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClient;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.SendMessageRequest;

import javax.inject.Inject;

public class QueueServiceImpl implements QueueService {
    private final AmazonSQS sqs;
    private final static String QUEUE_URL = "https://sqs.us-east-1.amazonaws.com/803611297537/marketplace_grupo4";

    @Inject
    public QueueServiceImpl(){
        this.sqs = AmazonSQSClientBuilder.defaultClient();
    }

    public void sendMessage(String message){
        SendMessageRequest send_msg_request = new SendMessageRequest()
                .withQueueUrl(QUEUE_URL)
                .withMessageBody(message)
                .withDelaySeconds(5);
        sqs.sendMessage(send_msg_request);
    }
}