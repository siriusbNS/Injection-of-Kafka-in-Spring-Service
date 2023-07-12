package is.technologies.kafka;

import com.example.jartest.entities.carBrand;
import com.example.jartest.entities.carModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Collection;
@Service
public class CarModelKafkaConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(CarModelKafkaConsumer.class);
    private Collection<carModel> carModels;
    @KafkaListener(topics = "carmodeltopic35",groupId = "myGroup")
    public Collection<carModel> consume(Collection<carModel> carModels)
    {
        LOGGER.info(String.format("Message recieved -> %s",carModels));
        this.carModels = carModels;
        return carModels;
    }

    public Collection<carModel> getCarModelss() {
        return  carModels;
    }
}
