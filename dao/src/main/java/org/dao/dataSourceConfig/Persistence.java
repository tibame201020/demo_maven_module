package org.dao.dataSourceConfig;

import org.springframework.jdbc.core.JdbcTemplate;

public enum Persistence {
    DB1 {
        @Override
        public JdbcTemplate getValue() {
            return JdbcBeans.getMultiJDBC1();
        }
    },
    DB2 {
        @Override
        public JdbcTemplate getValue() {
            return JdbcBeans.getMultiJDBC2();
        }
    };

    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getValue() {
        return jdbcTemplate;
    }

    public void setValue(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
