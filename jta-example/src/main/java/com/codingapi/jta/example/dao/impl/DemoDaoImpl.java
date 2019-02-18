package com.codingapi.jta.example.dao.impl;

import com.codingapi.jta.example.dao.DemoDao;
import com.codingapi.jta.example.domain.Demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DemoDaoImpl implements DemoDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int save(Demo demo) {
        String sql = "insert into t_demo(name) values(?)";
        return jdbcTemplate.update(sql, demo.getName());
    }

}