package com.taomish.service;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.Optional;

@Service
@EnableConfigurationProperties(ServiceProperties.class)
public class CustomerService {

    private final DataSource dataSource;
    private final CustomerRepository customerRepository;

    private final ServiceProperties serviceProperties;

    public CustomerService(DataSource dataSource, CustomerRepository customerRepository, ServiceProperties serviceProperties) {
        this.dataSource = dataSource;
        this.customerRepository = customerRepository;
        this.serviceProperties = serviceProperties;
    }

    public Optional<Customer> createCustomer() {
        var entity = customerRepository.save(new Customer(1L, serviceProperties.getMessage(), 34));
        return customerRepository.findById(entity.getId());
    }
}
