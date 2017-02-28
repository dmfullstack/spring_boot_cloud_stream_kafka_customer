package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.stream.annotation.EnableBinding;

@SpringBootApplication
@EnableEurekaClient
@EnableBinding(Barista.class)
public class KafkaPocCustomerApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaPocCustomerApplication.class, args);
	}

}
