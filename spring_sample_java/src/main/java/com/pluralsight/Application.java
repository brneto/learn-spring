package com.pluralsight;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.pluralsight.service.CustomerService;

public class Application {

	public static void main(String[] args) {

		try (ConfigurableApplicationContext context =
				new AnnotationConfigApplicationContext(AppConfig.class)) {
			
			CustomerService service =
					context.getBean("customerService", CustomerService.class);
			
			System.out.println(service.findAll().get(0).getFirstname());
		}
	}

}
