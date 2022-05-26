package com.ty.food_app_boot.food_app_boot;

import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;


import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class FoodAppBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodAppBootApplication.class, args);
	}
	
	@Bean
	public Docket getDocket() { 
		Contact contact = new Contact("Frozen_bottle_project", "www.frozenbottle.com", "frozenbottle@gmail.com");

		List<VendorExtension> extensions = new ArrayList<VendorExtension>();

		ApiInfo apiInfo = new ApiInfo("Frozen Bottle Project", "Project of Frozen Project", "SNAPSHOT 1.0",
				"www.frozen_bottle.com", contact, "9972243977", "Licence123", extensions);

		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("com.ty"))
				.build().apiInfo(apiInfo).useDefaultResponseMessages(false);
	}
	
	@Autowired
	EmailService service;
	
	static String email="cmvaibhav8904@gmail.com";
	static String msg="hi admin";
	
	public static void Email(String vemail,String message) {
		 email=vemail;
		 msg=message;
	}
	
	@EventListener(ApplicationReadyEvent.class)
	public void triggerMail() throws MessagingException {
		service.sendSimpleEmail("cmvaibhav4@gmail.com",email, msg, "welcome to Forzen_Bottle !!!!!!!");
	}


}