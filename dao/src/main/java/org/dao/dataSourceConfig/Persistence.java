package org.dao.dataSourceConfig;

import org.springframework.jdbc.core.JdbcTemplate;

public enum Persistence {

    DATABASE3 {
        @Override
        public JdbcTemplate getValue() {
            return JdbcBeans.getDatabase3Jdbc();
        }
    },
    DATABASE2 {
        @Override
        public JdbcTemplate getValue() {
            return JdbcBeans.getDatabase2Jdbc();
        }
    },
    DATABASE1 {
        @Override
        public JdbcTemplate getValue() {
            return JdbcBeans.getDatabase1Jdbc();
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

