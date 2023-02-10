package com.braintree;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;


@SpringBootApplication
@Configuration
public class BraintreeApplication {

	public static void main(String[] args) {
		SpringApplication.run(BraintreeApplication.class, args);
	}

}
