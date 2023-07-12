package is.technologies.kafka;


import com.example.jartest.entities.carBrand;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class JsonKafkaConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaConsumer.class);
    private Collection<carBrand> carBrands;
    @KafkaListener(topics = "carbrandtopic35",groupId = "myGroup")
    public Collection<carBrand> consume(Collection<carBrand> carBrandList)
    {
        LOGGER.info(String.format("Message recieved -> %s",carBrandList));
        carBrands = carBrandList;
        return carBrandList;
    }

    public Collection<carBrand> getCarBrands() {
        return  carBrands;
    }
}
