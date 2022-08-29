package org.dao.dataSourceConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
@ImportResource("classpath:jdbc-beans.xml")
public class JdbcBeans {
    
    private static JdbcTemplate database3Jdbc;

    public static JdbcTemplate getDatabase3Jdbc() {
        return database3Jdbc;
    }

    @Autowired
    public void setDatabase3Jdbc(@Qualifier("database3Jdbc") JdbcTemplate database3Jdbc) {
        JdbcBeans.database3Jdbc = database3Jdbc;
    }

    private static JdbcTemplate database2Jdbc;

    public static JdbcTemplate getDatabase2Jdbc() {
        return database2Jdbc;
    }

    @Autowired
    public void setDatabase2Jdbc(@Qualifier("database2Jdbc") JdbcTemplate database2Jdbc) {
        JdbcBeans.database2Jdbc = database2Jdbc;
    }

    private static JdbcTemplate database1Jdbc;

    public static JdbcTemplate getDatabase1Jdbc() {
        return database1Jdbc;
    }

    @Autowired
    public void setDatabase1Jdbc(@Qualifier("database1Jdbc") JdbcTemplate database1Jdbc) {
        JdbcBeans.database1Jdbc = database1Jdbc;
    }

}

