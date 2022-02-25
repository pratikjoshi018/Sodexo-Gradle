package com.java.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.java.service.OtpService;
import com.techprimers.spring_boot_soap_example.GetMobileOTPRequest;
import com.techprimers.spring_boot_soap_example.GetMobileOTPResponse;
import com.techprimers.spring_boot_soap_example.SubmitOTPRequest;
import com.techprimers.spring_boot_soap_example.SubmitOTPResponse;

@Endpoint
public class OtpEndpoint {
	
	@Autowired
	OtpService otpService;
	
	@PayloadRoot(namespace = "http://techprimers.com/spring-boot-soap-example",
            localPart = "getMobileOTPRequest")
	@ResponsePayload
	public GetMobileOTPResponse  getMobileOTPRequest(@RequestPayload GetMobileOTPRequest request) {
		GetMobileOTPResponse response = new GetMobileOTPResponse();;
		try {
		
		response.setResponse(otpService.createapitest());
		response.setStatus("success");
		response.setTransactionId("trasaction_test_Id_0001");
		System.out.println(" Inside create transaction Endpoint...");
		} 
		catch(Exception e) {
			System.out.println("Exception: "+e);
		}
		return response;
	}  
	
	@PayloadRoot(namespace = "http://techprimers.com/spring-boot-soap-example",
            localPart = "submitOTPRequest")
	@ResponsePayload
	public SubmitOTPResponse  submitOTPRequest(@RequestPayload SubmitOTPRequest request) {
		SubmitOTPResponse response = new SubmitOTPResponse();;
		try {
		
		response.setResponse(otpService.submitAPItest());
		response.setStatus("success");
		System.out.println("Inside submit otp Endpoint...");
		} 
		catch(Exception e) {
			System.out.println("Exception: "+e);
		}
		return response;
	} 

}
