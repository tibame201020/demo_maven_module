package org.dao.dataSourceConfig;

import org.springframework.jdbc.core.JdbcTemplate;

public enum Persistence {

    TESTMULTIDB3 {
        @Override
        public JdbcTemplate getValue() {
            return JdbcBeans.getTestMultiDb3Jdbc();
        }
    },
    TESTMULTIDB2 {
        @Override
        public JdbcTemplate getValue() {
            return JdbcBeans.getTestMultiDb2Jdbc();
        }
    },
    TESTMULTIDB1 {
        @Override
        public JdbcTemplate getValue() {
            return JdbcBeans.getTestMultiDb1Jdbc();
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

