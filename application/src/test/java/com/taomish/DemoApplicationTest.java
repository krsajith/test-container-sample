package com.taomish;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.taomish.service.CustomerService;

@SpringBootTest
class DemoApplicationTest {

	@Autowired
	private CustomerService customerService;

	@Test
	void contextLoads() {
		assertThat(customerService.createCustomer()).isNotNull();
	}

}
