package com.example.carmodelsmicroservice.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.TopicBuilder;

public class CarModelKafkaTopicConfig {
    @Bean
    public NewTopic newJavaTopic()
    {
        return TopicBuilder.name("carmodeltopic34")
                .build();
    }
    @Bean
    public NewTopic newJavaJsonTopic()
    {
        return TopicBuilder.name("carmodeltopic35")
                .build();
    }
}
