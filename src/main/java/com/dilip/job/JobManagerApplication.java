package com.dilip.job;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class JobManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(JobManagerApplication.class, args);
	}
	
	
	


}
