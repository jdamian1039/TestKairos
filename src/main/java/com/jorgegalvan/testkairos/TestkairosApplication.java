package com.jorgegalvan.testkairos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class TestkairosApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestkairosApplication.class, args);
	}

}
