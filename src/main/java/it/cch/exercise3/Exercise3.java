package it.cch.exercise3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;

//@EnableSwagger2
@SpringBootApplication
@EntityScan("it.cch.data")
public class Exercise3 {

	public static void main(String[] args) {
		SpringApplication.run(Exercise3.class, args);
	}

}
