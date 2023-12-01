package com.springBootTask;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Spring task", version = "3.0", description = "order Information"))
public class SpringBootTaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootTaskApplication.class, args);
	}

System.out.println("hellow");


}
