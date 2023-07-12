package is.technologies.controllers;


import com.example.jartest.entities.carBrand;
import io.swagger.annotations.Api;



import is.technologies.kafka.JsonKafkaConsumer;
import is.technologies.kafka.JsonKafkaProducer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/BrandOfCars")
@Api(value = "Car Brands resources",description = "CRUD operations")
public class CarBrandRestController {
    private JsonKafkaProducer kafkaProducer;
    private JsonKafkaConsumer kafkaConsumer;
    @Autowired
    public CarBrandRestController(JsonKafkaProducer kafkaProducer, JsonKafkaConsumer kafkaConsumer) {
        this.kafkaProducer = kafkaProducer;
        this.kafkaConsumer = kafkaConsumer;
    }

    @GetMapping("/carBrands")
    public Collection<carBrand> allCarBrands()
   {
       kafkaProducer.getCarBrands("give car brands");
        return this.kafkaConsumer.getCarBrands();
    }
    @PostMapping("/carBrands")
    public void newCarBrand(@RequestBody carBrand carBrand)
    {

        kafkaProducer.sendCarBrand(carBrand);
    }
//    @GetMapping("/carBrands/{id}")
//    public carBrand findCarBrand(@PathVariable Integer id) throws Exception {
//        return kafkaProducer.();
//
//    }
   /* @PutMapping("/carBrands/{id}")
    public void updateCarBrand(@PathVariable Integer id,@RequestBody carBrand carBrand) throws Exception {
         this.carBrandRepository.update(carBrand.getName(),carBrand.getFoundingDate(),id);
    }
    @DeleteMapping("/carBrands/{id}")
    public void delete(@PathVariable Integer id) throws Exception {
        this.carBrandRepository.deleteById(id);
    }
    @GetMapping("/carBrands/Name/{name}")
    public Collection<carBrand> allCarBrandsByName(@PathVariable String name)
    {

        return this.carBrandRepository.getAllByName(name);
    }
    @GetMapping("/carBrands/Date/{date}")
    public Collection<carBrand> allCarBrandsByFoundingDate(@PathVariable String date) throws ParseException {
        Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(date);
        java.sql.Date date2 = new java.sql.Date(date1.getYear(),date1.getMonth(),date1.getDay());
        System.out.println(date2);
        return this.carBrandRepository.getAllByFoundingDate(date2);
    }*/

}
