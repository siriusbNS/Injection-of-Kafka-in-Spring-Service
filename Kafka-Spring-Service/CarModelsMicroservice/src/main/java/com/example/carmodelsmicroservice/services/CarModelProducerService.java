package com.example.carmodelsmicroservice.services;

import com.example.jartest.entities.carModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.Collection;
@Service
public class CarModelProducerService {
    private static final Logger LOGGER = LoggerFactory.getLogger(CarModelProducerService.class);
    private KafkaTemplate<String, Collection<carModel>> kafkaTemplate;

    public CarModelProducerService(KafkaTemplate<String, Collection<carModel>> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(Collection<carModel> carModels)
    {

        Message<Collection<carModel>> message = MessageBuilder
                .withPayload(carModels)
                .setHeader(KafkaHeaders.TOPIC,"carmodeltopic35")
                .build();
        LOGGER.info(String.format("Message sent-> %s",carModels));
        kafkaTemplate.send(message);

    }
}
