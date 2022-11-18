package com.KodlamaioHomeWork5thDay.HomeWork5thDay;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HomeWork5thDayApplication {

	public static void main(String[] args) {
		SpringApplication.run(HomeWork5thDayApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}
}
