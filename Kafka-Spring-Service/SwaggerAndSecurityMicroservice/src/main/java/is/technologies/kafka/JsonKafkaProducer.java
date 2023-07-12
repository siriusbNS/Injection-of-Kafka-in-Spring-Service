package is.technologies.kafka;




import com.example.jartest.entities.carBrand;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JsonKafkaProducer {
    private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaProducer.class);
    private KafkaTemplate<String, carBrand> kafkaTemplate;

    public JsonKafkaProducer(KafkaTemplate<String, carBrand> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendCarBrand(carBrand carBrand)
    {
        LOGGER.info(String.format("Message sent-> %s",carBrand.toString()));
        Message<carBrand> message = MessageBuilder
                .withPayload(carBrand)
                .setHeader(KafkaHeaders.TOPIC,"carbrandtopic33")
                .build();
        kafkaTemplate.send(message);

    }
    public void getCarBrands(String message1)
    {
        LOGGER.info(String.format("Message sent-> %s",message1));
        Message<String> message = MessageBuilder
                .withPayload(message1)
                .setHeader(KafkaHeaders.TOPIC,"carbrandtopic34")
                .build();
        kafkaTemplate.send(message);

    }
}
