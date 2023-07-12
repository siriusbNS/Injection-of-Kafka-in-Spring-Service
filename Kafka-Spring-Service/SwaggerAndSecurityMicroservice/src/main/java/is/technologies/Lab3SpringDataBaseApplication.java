package is.technologies;



import is.technologies.controllers.CarBrandRestController;
import is.technologies.entities.carBrand;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Configuration
@SpringBootApplication
public class Lab3SpringDataBaseApplication {

    public static void main(String[] args) throws ParseException {

        SpringApplication.run(Lab3SpringDataBaseApplication.class, args);

    }

}
