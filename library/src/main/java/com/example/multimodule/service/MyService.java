package com.example.multimodule.service;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;

@Service
@EnableConfigurationProperties(ServiceProperties.class)
public class MyService {

	private final DataSource dataSource;
	private final CustomerRepository customerRepository;

	private final ServiceProperties serviceProperties;

	public MyService(DataSource dataSource, CustomerRepository customerRepository, ServiceProperties serviceProperties) {
        this.dataSource = dataSource;
        this.customerRepository = customerRepository;
        this.serviceProperties = serviceProperties;
	}

	public String message() {
		 var entity = customerRepository.save(new Customer(1L, serviceProperties.getMessage(),34));
		return customerRepository.findById(entity.getId()).orElse(new Customer()).getName();
	}
}
