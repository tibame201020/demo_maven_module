package org.dao.dataSourceConfig;

import org.springframework.jdbc.core.JdbcTemplate;

public enum Persistence {

    DB1 {
        @Override
        public JdbcTemplate getValue() {
            return JdbcBeans.getDb1Jdbc();
        }
    },
    DB3 {
        @Override
        public JdbcTemplate getValue() {
            return JdbcBeans.getDb3Jdbc();
        }
    },
    DB2 {
        @Override
        public JdbcTemplate getValue() {
            return JdbcBeans.getDb2Jdbc();
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

