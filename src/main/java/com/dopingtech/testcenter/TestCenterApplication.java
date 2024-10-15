package com.dopingtech.testcenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class TestCenterApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestCenterApplication.class, args);
	}

}
