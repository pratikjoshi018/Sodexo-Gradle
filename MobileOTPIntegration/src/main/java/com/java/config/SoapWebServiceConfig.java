package com.java.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class SoapWebServiceConfig extends WsConfigurerAdapter {
	
//	 @SuppressWarnings({ "rawtypes", "unchecked" })
	@Bean
	    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext context) {
	        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
	        servlet.setApplicationContext(context);
	        servlet.setTransformWsdlLocations(true);
	        return new ServletRegistrationBean<MessageDispatcherServlet>(servlet, "/soapWS/*");
	    }
	 
	 @Bean
	    public XsdSchema mobileOTPSchema() {
	        return new SimpleXsdSchema(new ClassPathResource("mobileOTP.xsd"));
	    }
	 
	 @Bean(name = "mobileOTPWsdl")
	    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema mobileOTPSchema) {

	        DefaultWsdl11Definition definition = new DefaultWsdl11Definition();
	        definition.setSchema(mobileOTPSchema);
	        definition.setLocationUri("/soapWS");
	        definition.setPortTypeName("MobileOTPServicePort");
	        definition.setTargetNamespace("http://techprimers.com/spring-boot-soap-example");
	        return definition;
	    }


}
