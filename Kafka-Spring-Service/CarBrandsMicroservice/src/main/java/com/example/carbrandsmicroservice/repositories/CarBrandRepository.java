package com.example.carbrandsmicroservice.repositories;





import com.example.jartest.entities.carBrand;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.sql.Date;
import java.util.*;

@Repository
@EntityScan("com.example.jartest.*")
public interface CarBrandRepository extends JpaRepository<carBrand,Integer> {
List<carBrand> getAllByName(String name);
List<carBrand> getAllByFoundingDate(Date date);
carBrand getById(Integer id);
carBrand getByName(String name);
@Modifying(clearAutomatically = true)
@Transactional
@Query("update carBrand set name=:name_ , foundingDate= :foundingDate_ where id= :id_")
void update(@Param("name_") String brandname,@Param("foundingDate_") Date foundingdate, @Param("id_") Integer brandid);

}
