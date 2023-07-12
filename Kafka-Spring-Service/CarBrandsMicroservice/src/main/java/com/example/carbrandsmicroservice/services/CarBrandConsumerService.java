package com.example.carbrandsmicroservice.services;

import com.example.carbrandsmicroservice.repositories.CarBrandRepository;

import com.example.jartest.entities.carBrand;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@EntityScan("com.example.jartest.*")
public class CarBrandConsumerService {
    private static final Logger LOGGER = LoggerFactory.getLogger(CarBrandConsumerService.class);
    private final CarBrandRepository carBrandRepository;
    private CarBrandProducerService carBrandProducerService;
    @Autowired
    public CarBrandConsumerService(CarBrandRepository carBrandRepository, CarBrandProducerService carBrandProducerService) {
        this.carBrandRepository = carBrandRepository;
        this.carBrandProducerService = carBrandProducerService;
    }

    @KafkaListener(topics = "carbrandtopic33",groupId = "myGroup")
    public void consume(carBrand carBrand)
    {
        LOGGER.info(String.format("Message recieved -> %s",carBrand.toString()));
        carBrandRepository.save(carBrand);
    }
    @KafkaListener(topics = "carbrandtopic34",groupId = "myGroup")
    public void getAll()
    {
        Collection<carBrand> carBrands = carBrandRepository.findAll();
        LOGGER.info(String.format("Message recieved -> %s",carBrands.toString()));

        carBrandProducerService.sendMessage(carBrands);

    }

}
