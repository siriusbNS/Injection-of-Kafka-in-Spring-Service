package com.example.carbrandsmicroservice;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.example.jartest.*")
public class CarBrandsMicroserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarBrandsMicroserviceApplication.class, args);

    }

}
