package org.dao.dao;

import org.dao.dataSourceConfig.Persistence;
import org.springframework.dao.DataAccessException;

import java.util.List;
import java.util.Map;


public interface Dao {

    // map的key與db的column完全相同
    List<Map<String, Object>> query(String sql, List<Object> params, Persistence persistence) throws DataAccessException;

    // useCamelCase => map的key是否要使用駝峰式命名
    List<Map<String, Object>> query(String sql, List<Object> params, Persistence persistence, boolean useCamelCase) throws DataAccessException;

    <T> List<T> query(String sql, List<Object> params, Persistence persistence, Class<T> c) throws DataAccessException;

    int update(String sql, List<Object> params, Persistence persistence) throws DataAccessException;

    int insert(String sql, List<Object> params, Persistence persistence) throws DataAccessException;

    //批量更新 List<Object>為一組條件，故外層再包一層List為多組條件
    int[] batchUpdate(String sql, List<List<Object>> params, Persistence persistence) throws DataAccessException;

    int[] batchInsert(String sql, List<List<Object>> params, Persistence persistence) throws DataAccessException;

    void execute(String sql, Persistence persistence) throws DataAccessException;

}
