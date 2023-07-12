package is.technologies.kafka;

import com.example.jartest.entities.carBrand;
import com.example.jartest.entities.carModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class CarModelKafkaProducer {
    private static final Logger LOGGER = LoggerFactory.getLogger(CarModelKafkaProducer.class);
    private KafkaTemplate<String, carModel> kafkaTemplate;

    public CarModelKafkaProducer(KafkaTemplate<String, carModel> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendCarModel(carModel carModel)
    {
        LOGGER.info(String.format("Message sent-> %s",carModel.toString()));
        Message<carModel> message = MessageBuilder
                .withPayload(carModel)
                .setHeader(KafkaHeaders.TOPIC,"carmodeltopic33")
                .build();
        kafkaTemplate.send(message);

    }
    public void getCarModels(String message1)
    {
        LOGGER.info(String.format("Message sent-> %s",message1));
        Message<String> message = MessageBuilder
                .withPayload(message1)
                .setHeader(KafkaHeaders.TOPIC,"carmodeltopic34")
                .build();
        kafkaTemplate.send(message);

    }
}
