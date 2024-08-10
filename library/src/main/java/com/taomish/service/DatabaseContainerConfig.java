package com.taomish.service;

import liquibase.integration.spring.SpringLiquibase;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.testcontainers.containers.PostgreSQLContainer;

import javax.sql.DataSource;


@Configuration
public class DatabaseContainerConfig {

    private final PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>(
            "postgres:16-alpine"
    );

    @Bean
    public DataSource getDataSource() {
        postgres.start();
        DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.url(postgres.getJdbcUrl());
        dataSourceBuilder.username(postgres.getUsername());
        dataSourceBuilder.password(postgres.getPassword());
        return dataSourceBuilder.build();
    }

    @Bean
    public SpringLiquibase commonLiquibase(DataSource dataSource) {
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setDataSource(dataSource);
        liquibase.setChangeLog("classpath:db/changelog/common.changelog-master.yaml");
        return liquibase;
    }

}
