package com.java;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.java.service.OtpService;

@SpringBootApplication
public class MobileOtpIntegrationApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(OtpService.class);
	
	public static void main(String[] args) {
		SpringApplication.run(MobileOtpIntegrationApplication.class, args);
		LOGGER.info("APPLICATION STARTED");
		System.out.println("Application started.... ");
	}

}
