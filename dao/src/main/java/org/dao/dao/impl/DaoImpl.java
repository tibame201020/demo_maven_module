package org.dao.dao.impl;

import org.dao.dao.Dao;
import org.dao.dataSourceConfig.Persistence;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.util.Converter;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Service
public class DaoImpl implements Dao {


    @Override
    public List<Map<String, Object>> query(String sql, List<Object> params, Persistence persistence) {
        if (CollectionUtils.isEmpty(params)) {
            return persistence.getValue().query(sql, (rs, rowNum) -> (Converter.resultSetToMap(rs, false)));
        }
        return persistence.getValue().query(sql, toPreparedStatementSetter(params), (rs, rowNum) -> (Converter.resultSetToMap(rs, false)));
    }

    @Override
    public List<Map<String, Object>> query(String sql, List<Object> params, Persistence persistence, boolean useCamelCase) {
        if (CollectionUtils.isEmpty(params)) {
            return persistence.getValue().query(sql, (rs, rowNum) -> (Converter.resultSetToMap(rs, useCamelCase)));
        }
        return persistence.getValue().query(sql, toPreparedStatementSetter(params), (rs, rowNum) -> (Converter.resultSetToMap(rs, useCamelCase)));
    }

    @Override
    public <T> List<T> query(String sql, List<Object> params, Persistence persistence, Class<T> c) {
        if (CollectionUtils.isEmpty(params)) {
            return persistence.getValue().query(sql, (rs, rowNum) -> (Converter.resultSetToObject(rs, c)));
        }
        return persistence.getValue().query(sql, toPreparedStatementSetter(params), (rs, rowNum) -> (Converter.resultSetToObject(rs, c)));
    }

    @Override
    public int update(String sql, List<Object> params, Persistence persistence) {
        if (CollectionUtils.isEmpty(params)) {
            return persistence.getValue().update(sql);
        }
        return persistence.getValue().update(sql, toPreparedStatementSetter(params));
    }

    @Override
    public int insert(String sql, List<Object> params, Persistence persistence) {
        if (CollectionUtils.isEmpty(params)) {
            return persistence.getValue().update(sql);
        }
        return persistence.getValue().update(sql, toPreparedStatementSetter(params));
    }

    @Override
    public int[] batchUpdate(String sql, List<List<Object>> params, Persistence persistence) {
        if (CollectionUtils.isEmpty(params)) {
            return persistence.getValue().batchUpdate(sql);
        }
        return persistence.getValue().batchUpdate(sql, toBatchPreparedStatementSetter(params));
    }

    @Override
    public int[] batchInsert(String sql, List<List<Object>> params, Persistence persistence) {
        if (CollectionUtils.isEmpty(params)) {
            return persistence.getValue().batchUpdate(sql);
        }
        return persistence.getValue().batchUpdate(sql, toBatchPreparedStatementSetter(params));
    }

    @Override
    public void execute(String sql, Persistence persistence) throws DataAccessException {
        persistence.getValue().execute(sql);
    }

    // PreparedStatement
    private PreparedStatementSetter toPreparedStatementSetter(List<Object> params) {
        return ps -> {
            for (int i = 0; i < params.size(); i++) {
                ps.setObject(i + 1, params.get(i));
            }
        };
    }

    // 批次的PreparedStatement
    private BatchPreparedStatementSetter toBatchPreparedStatementSetter(List<List<Object>> params) {
        return new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                List<Object> singleParam = params.get(i);
                for (int j = 0; j < singleParam.size(); j++) {
                    ps.setObject(j + 1, params.get(i).get(j));
                }
            }

            @Override
            public int getBatchSize() {
                return params.size();
            }
        };
    }

}
