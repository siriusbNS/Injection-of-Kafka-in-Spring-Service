package com.example.carbrandsmicroservice.services;

import com.example.jartest.entities.carBrand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class CarBrandProducerService {
    private static final Logger LOGGER = LoggerFactory.getLogger(CarBrandConsumerService.class);
    private KafkaTemplate<String, Collection<carBrand>> kafkaTemplate;

    public CarBrandProducerService(KafkaTemplate<String, Collection<carBrand>> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(Collection<carBrand> carBrandlist)
    {

        Message<Collection<carBrand>> message = MessageBuilder
                .withPayload(carBrandlist)
                .setHeader(KafkaHeaders.TOPIC,"carbrandtopic35")
                .build();
        LOGGER.info(String.format("Message sent-> %s",carBrandlist));
        kafkaTemplate.send(message);

    }
}
