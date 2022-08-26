package org.batch;

import org.dao.dao.impl.DaoImpl;
import org.dao.dataSourceConfig.JdbcBeans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@Import({DaoImpl.class, JdbcBeans.class})
public class BatchApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(BatchApplication.class, args);
        context.getBean(Main.class).execute();
    }

}
