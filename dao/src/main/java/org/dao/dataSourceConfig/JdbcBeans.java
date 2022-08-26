package org.dao.dataSourceConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
@ImportResource("classpath:jdbc-beans.xml")
public class JdbcBeans {
    private static JdbcTemplate multiJDBC1;
    private static JdbcTemplate multiJDBC2;


    public static JdbcTemplate getMultiJDBC1() {
        return multiJDBC1;
    }

    @Autowired
    public void setMultiJDBC1(@Qualifier("multiJDBC1") JdbcTemplate multiJDBC1) {
        JdbcBeans.multiJDBC1 = multiJDBC1;
    }

    public static JdbcTemplate getMultiJDBC2() {
        return multiJDBC2;
    }

    @Autowired
    public void setMultiJDBC2(@Qualifier("multiJDBC2") JdbcTemplate multiJDBC2) {
        JdbcBeans.multiJDBC2 = multiJDBC2;
    }

}
