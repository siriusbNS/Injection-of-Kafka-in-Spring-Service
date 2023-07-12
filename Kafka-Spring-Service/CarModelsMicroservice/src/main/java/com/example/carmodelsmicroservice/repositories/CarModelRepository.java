package com.example.carmodelsmicroservice.repositories;


import com.example.jartest.entities.Person;
import com.example.jartest.entities.carModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CarModelRepository extends JpaRepository<carModel,Integer> {
}
