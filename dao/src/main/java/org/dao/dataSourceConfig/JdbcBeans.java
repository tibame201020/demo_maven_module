package org.dao.dataSourceConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
@ImportResource("classpath:jdbc-beans.xml")
public class JdbcBeans {
    
    private static JdbcTemplate db1Jdbc;

    public static JdbcTemplate getDb1Jdbc() {
        return db1Jdbc;
    }

    @Autowired
    public void setDb1Jdbc(@Qualifier("db1Jdbc") JdbcTemplate db1Jdbc) {
        JdbcBeans.db1Jdbc = db1Jdbc;
    }

    private static JdbcTemplate db3Jdbc;

    public static JdbcTemplate getDb3Jdbc() {
        return db3Jdbc;
    }

    @Autowired
    public void setDb3Jdbc(@Qualifier("db3Jdbc") JdbcTemplate db3Jdbc) {
        JdbcBeans.db3Jdbc = db3Jdbc;
    }

    private static JdbcTemplate db2Jdbc;

    public static JdbcTemplate getDb2Jdbc() {
        return db2Jdbc;
    }

    @Autowired
    public void setDb2Jdbc(@Qualifier("db2Jdbc") JdbcTemplate db2Jdbc) {
        JdbcBeans.db2Jdbc = db2Jdbc;
    }

}

