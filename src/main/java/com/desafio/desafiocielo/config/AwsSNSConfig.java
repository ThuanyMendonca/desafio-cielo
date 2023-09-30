package com.desafio.desafiocielo.config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;
import com.amazonaws.services.sns.model.MessageAttributeValue;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.PublishResult;
import com.amazonaws.services.sns.model.Topic;
import com.desafio.desafiocielo.dtos.PessoaSNS;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Configuration
public class AwsSNSConfig {
    @Bean
    @Primary
    public AmazonSNSClient getAmazonSNSClient() {
        return (AmazonSNSClient) AmazonSNSClientBuilder.standard().withRegion(Regions.US_EAST_1)
                .withCredentials(
                        new AWSStaticCredentialsProvider(
                                new BasicAWSCredentials("AKIAVDSQS2ZKQ4FJLK7E", "gK54ogxg8GXLoubW/WgHx1HjTlMYG6iqj2k0GIjO")
                        )
                ).build();
    }

    public PublishResult publishSNS(PessoaSNS pessoaSNS) {

        AmazonSNSClient client = getAmazonSNSClient();
        String topicArn = client.listTopics().getTopics().stream().filter(t -> t.getTopicArn().endsWith("prospect.fifo")).findFirst().map(Topic::getTopicArn).orElse(null);
        if(topicArn == null) {
            throw new RuntimeException("topic not found");
        }

        PublishRequest publishRequest = new PublishRequest(topicArn, pessoaSNS.getMessage().toString(), pessoaSNS.getTipo()).withMessageDeduplicationId(UUID.randomUUID().toString()).withMessageGroupId(pessoaSNS.getTipo());
        Map<String, MessageAttributeValue> messageAttributes = new HashMap<>();
        MessageAttributeValue tipo = new MessageAttributeValue();
        tipo.setDataType("String");
        tipo.setStringValue(pessoaSNS.getTipo());
        messageAttributes.put("tipo", tipo);
        MessageAttributeValue status = new MessageAttributeValue();
        status.setDataType("String");
        status.setStringValue(pessoaSNS.getStatus());
        messageAttributes.put("status", status);
        publishRequest.setMessageAttributes(messageAttributes);


        PublishResult publishResult = client.publish(publishRequest);

        return publishResult;


    }
}
