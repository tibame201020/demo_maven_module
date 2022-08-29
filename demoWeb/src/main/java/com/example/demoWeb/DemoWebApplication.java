package com.example.demoWeb;

import org.dao.dao.impl.DaoImpl;
import org.dao.dataSourceConfig.JdbcBeans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({DaoImpl.class, JdbcBeans.class})
public class DemoWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoWebApplication.class, args);

    }

}
