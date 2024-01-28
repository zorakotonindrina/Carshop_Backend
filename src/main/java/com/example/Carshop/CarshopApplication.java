package com.example.Carshop;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
@EntityScan("com.example.Carshop.Model")
@SpringBootApplication
public class CarshopApplication {
	public static void main(String[] args) {
		SpringApplication.run(CarshopApplication.class, args);
	}
}