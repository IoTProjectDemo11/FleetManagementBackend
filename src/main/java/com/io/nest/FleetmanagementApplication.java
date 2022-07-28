package com.io.nest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.io.nest.mapper.UserMapper;
import com.io.nest.mapper.UserMapperImpl;

@SpringBootApplication
public class FleetmanagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(FleetmanagementApplication.class, args);
	}
	@Bean
	public UserMapper getUserMapper() {
		return new UserMapperImpl();
	}
	
	
}
