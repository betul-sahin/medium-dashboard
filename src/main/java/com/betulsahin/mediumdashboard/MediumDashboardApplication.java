package com.betulsahin.mediumdashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties
@SpringBootApplication
public class MediumDashboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(MediumDashboardApplication.class, args);
	}
}
