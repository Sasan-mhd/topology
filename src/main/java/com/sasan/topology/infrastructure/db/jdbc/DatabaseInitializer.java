package com.sasan.topology.infrastructure.db.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Types;

@Configuration
public class DatabaseInitializer {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Bean
    CommandLineRunner loadDatabase() {
        return new CommandLineRunner() {

            @Override
            public void run(String... args) throws Exception {

                jdbcTemplate.execute("create table graphs (id int primary key auto_increment, graph java_object)");

                jdbcTemplate.update(
                        "insert into graphs (graph) values(?)",
                        new Object[] {null},
                        new int[] { Types.JAVA_OBJECT });
            }
        };
    }
}
