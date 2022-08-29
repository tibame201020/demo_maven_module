package org.batch.service.impl;

import org.batch.service.BatchService;
import org.dao.dao.Dao;
import org.dao.dataSourceConfig.Persistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BatchServiceImpl implements BatchService {
    @Autowired
    private Dao dao;

    @Override
    public void updateSession() {
        String sql = "select * from article";
        List<Map<String, Object>> dataLs = dao.query(sql, null, Persistence.TESTMULTIDB1);
        for (Map<String, Object> dataMap : dataLs) {
            for (String key:
                 dataMap.keySet()) {
                System.out.println(key + " = " + dataMap.get(key));
            }
        }

    }
}
