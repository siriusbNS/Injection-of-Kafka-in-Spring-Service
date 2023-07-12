package is.technologies.controllers;


import com.example.jartest.entities.carBrand;
import is.technologies.kafka.JsonKafkaProducer;
import is.technologies.kafka.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/kafka")
public class TestKafkaController {
    private JsonKafkaProducer kafkaProducer;
    @Autowired
    public TestKafkaController(JsonKafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }
    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody
                                              carBrand carBrand)
    {
        kafkaProducer.sendCarBrand(carBrand);
        return ResponseEntity.ok("Message sent to the topic");
    }

}
