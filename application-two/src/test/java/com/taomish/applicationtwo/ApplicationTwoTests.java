package com.taomish.applicationtwo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootTest
@ComponentScan(basePackages = {"com.taomish"})
@EnableJpaRepositories(basePackages = { "com.taomish"})
@EntityScan(basePackages = { "com.taomish"})
class ApplicationTwoTests {

    @Test
    void contextLoads() {
    }

}
