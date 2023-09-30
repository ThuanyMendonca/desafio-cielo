package com.desafio.desafiocielo.config;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sqs.AmazonSQSClient;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.ReceiveMessageRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

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

    public  getMessage() {

    }
}
