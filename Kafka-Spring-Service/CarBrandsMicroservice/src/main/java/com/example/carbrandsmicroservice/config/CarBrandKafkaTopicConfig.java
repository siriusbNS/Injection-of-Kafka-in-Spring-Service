package com.example.carbrandsmicroservice.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class CarBrandKafkaTopicConfig {
    @Bean
    public NewTopic newJavaTopic()
    {
        return TopicBuilder.name("carbrandtopic34")
                .build();
    }
    @Bean
    public NewTopic newJavaJsonTopic()
    {
        return TopicBuilder.name("carbrandtopic35")
                .build();
    }
}
