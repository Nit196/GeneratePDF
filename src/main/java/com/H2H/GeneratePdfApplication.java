package com.H2H;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class GeneratePdfApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(GeneratePdfApplication.class, args);
	}
	
	
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder)
	{
		return builder.sources(GeneratePdfApplication.class);
	}
	

}
