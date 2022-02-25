package com.java.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class OtpService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(OtpService.class);
	
	public String createapitest() {
		System.out.println(" Inside Service...");
		LOGGER.info("Inside Create Transaction API ");
		return "Create API Test Succesful";
	}

	public String submitAPItest() {
		System.out.println(" Inside Service...");
		LOGGER.info("Inside Submit OTP API ");
		return "Submit OTP Test Succesful";
	}
}
