package com.taomish.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest("service.message=Hello")
class LibraryTest {

	@Autowired
	private CustomerService myService;

	@Test
	void createCustomerTest() {
		assertThat(myService.createCustomer()).isNotNull();
	}

	@SpringBootApplication
	static class TestConfiguration {
	}

}
