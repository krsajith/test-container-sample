package com.taomish.applicationone;

import com.taomish.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ComponentScan(basePackages = {"com.taomish"})
@EnableJpaRepositories(basePackages = { "com.taomish"})
@EntityScan(basePackages = { "com.taomish"})
class ApplicationOneTests {

    @Autowired
    private CustomerService customerService;

    @Test
    void contextLoads() {
        assertThat(customerService.createCustomer()).isNotNull();
    }

}
