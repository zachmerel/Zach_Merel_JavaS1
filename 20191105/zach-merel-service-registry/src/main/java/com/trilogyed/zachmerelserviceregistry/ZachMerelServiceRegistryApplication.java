package com.trilogyed.zachmerelserviceregistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ZachMerelServiceRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZachMerelServiceRegistryApplication.class, args);
	}

}
