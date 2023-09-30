package com.desafio.desafiocielo.config;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sqs.AmazonSQSClient;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.ReceiveMessageRequest;
import com.amazonaws.services.sqs.model.ReceiveMessageResult;
import com.desafio.desafiocielo.dtos.PessoaFisicaResponseDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Configuration
public class AwsSQSConfig {
    @Bean
    @Primary
    public AmazonSQSClient getAmazonSQSClient() {
        return (AmazonSQSClient) AmazonSQSClientBuilder.standard().withRegion(Regions.US_EAST_1)
                .withCredentials(
                        new AWSStaticCredentialsProvider(
                                new BasicAWSCredentials("AKIAVDSQS2ZKQ4FJLK7E", "gK54ogxg8GXLoubW/WgHx1HjTlMYG6iqj2k0GIjO")
                        )
                ).build();
    }

    public List<String> getMessages() {
        AmazonSQSClient client = getAmazonSQSClient();
        String queueUrl = client.getQueueUrl("prospect.fifo").getQueueUrl();

        ReceiveMessageRequest receiveMessageRequest = new ReceiveMessageRequest(queueUrl).withMaxNumberOfMessages(10).withVisibilityTimeout(20).withMessageAttributeNames("All");

        ReceiveMessageResult receiveMessageResult = client.receiveMessage(receiveMessageRequest);

        List<Message> messages = receiveMessageResult.getMessages();
        List<String> receivedMessages = new ArrayList<>();

        for(Message message: messages) {
            receivedMessages.add(message.getBody());
        }

        for(String messageBody: receivedMessages) {
            return Collections.singletonList(messageBody);
        }

        return null;
    }
}
