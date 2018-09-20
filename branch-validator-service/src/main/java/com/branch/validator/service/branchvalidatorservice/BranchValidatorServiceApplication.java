package com.branch.validator.service.branchvalidatorservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class BranchValidatorServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BranchValidatorServiceApplication.class, args);
	}
}
