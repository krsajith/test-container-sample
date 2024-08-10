package com.taomish.applicationtwo;

import liquibase.integration.spring.SpringLiquibase;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@SpringBootApplication
public class ApplicationTwoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationTwoApplication.class, args);
    }

    @Bean
    public SpringLiquibase applicationTwoLiquibase(DataSource dataSource) {
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setDataSource(dataSource);
        liquibase.setChangeLog("classpath:db/changelog/application-two.changelog.yaml");
        return liquibase;
    }
}
