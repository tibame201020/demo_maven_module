package com.example.demoWeb.controller;


import org.dao.dao.Dao;
import org.dao.dataSourceConfig.Persistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@RestController
public class TestController {

    @Autowired
    private Dao dao;

    @RequestMapping("test")
    public List<Map<String, Object>> test() throws Exception {
        String sql = "select * from Stock_Data";
        System.out.println(Persistence.TESTMULTIDB2.getValue().getDataSource().getClass());

        return dao.query(sql, null, Persistence.TESTMULTIDB2);
    }
}
