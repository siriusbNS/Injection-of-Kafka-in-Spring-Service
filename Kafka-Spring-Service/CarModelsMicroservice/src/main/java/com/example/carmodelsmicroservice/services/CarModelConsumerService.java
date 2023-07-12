package com.example.carmodelsmicroservice.services;

import com.example.carmodelsmicroservice.repositories.CarModelRepository;
import com.example.jartest.entities.carBrand;
import com.example.jartest.entities.carModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class CarModelConsumerService {
    private static final Logger LOGGER = LoggerFactory.getLogger(CarModelConsumerService.class);
    private final CarModelRepository carModelRepository;
    private CarModelProducerService carModelProducerService;
    @Autowired
    public CarModelConsumerService(CarModelRepository carModelRepository, CarModelProducerService carModelProducerService) {
        this.carModelRepository = carModelRepository;
        this.carModelProducerService = carModelProducerService;
    }

    @KafkaListener(topics = "carmodeltopic33",groupId = "myGroup")
    public void consume(carModel carModel)
    {
        LOGGER.info(String.format("Message recieved -> %s",carModel.toString()));
        carModelRepository.save(carModel);
    }
    @KafkaListener(topics = "carmodeltopic34",groupId = "myGroup")
    public void getAll()
    {
        Collection<carModel> carModels = carModelRepository.findAll();
        LOGGER.info(String.format("Message recieved -> %s",carModels.toString()));

        carModelProducerService.sendMessage(carModels);

    }
}
