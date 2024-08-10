package com.taomish.applicationone;

import liquibase.integration.spring.SpringLiquibase;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@SpringBootApplication
public class ApplicationOneApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationOneApplication.class, args);
    }

    @Bean
    public SpringLiquibase applicationOneLiquibase(DataSource dataSource) {
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setDataSource(dataSource);
        liquibase.setChangeLog("classpath:db/changelog/application-one.changelog.yaml");
        return liquibase;
    }
}
