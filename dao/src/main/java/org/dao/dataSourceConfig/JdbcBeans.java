package org.dao.dataSourceConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
@ImportResource("classpath:jdbc-beans.xml")
public class JdbcBeans {
    
    private static JdbcTemplate testMultiDb3Jdbc;

    public static JdbcTemplate getTestMultiDb3Jdbc() {
        return testMultiDb3Jdbc;
    }

    @Autowired
    public void setTestMultiDb3Jdbc(@Qualifier("testMultiDb3Jdbc") JdbcTemplate testMultiDb3Jdbc) {
        JdbcBeans.testMultiDb3Jdbc = testMultiDb3Jdbc;
    }

    private static JdbcTemplate testMultiDb2Jdbc;

    public static JdbcTemplate getTestMultiDb2Jdbc() {
        return testMultiDb2Jdbc;
    }

    @Autowired
    public void setTestMultiDb2Jdbc(@Qualifier("testMultiDb2Jdbc") JdbcTemplate testMultiDb2Jdbc) {
        JdbcBeans.testMultiDb2Jdbc = testMultiDb2Jdbc;
    }

    private static JdbcTemplate testMultiDb1Jdbc;

    public static JdbcTemplate getTestMultiDb1Jdbc() {
        return testMultiDb1Jdbc;
    }

    @Autowired
    public void setTestMultiDb1Jdbc(@Qualifier("testMultiDb1Jdbc") JdbcTemplate testMultiDb1Jdbc) {
        JdbcBeans.testMultiDb1Jdbc = testMultiDb1Jdbc;
    }

}

