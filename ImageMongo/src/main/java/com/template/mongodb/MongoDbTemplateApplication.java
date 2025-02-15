package com.template.mongodb;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MongoDbTemplateApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongoDbTemplateApplication.class, args);
	}

	@Bean
	public ModelMapper modelMap()
	{
		return new ModelMapper();
	}
}
