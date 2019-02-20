package com.codingapi.jta.example.service;


import com.codingapi.jta.example.dao.DemoDao;
import com.codingapi.jta.example.domain.Demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
public class DemoService2 {


    @Autowired
    private DemoDao demoDao;


    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void test(){
        Demo demo = new Demo();
        demo.setName("name");
        int res = demoDao.save(demo);
        System.out.println(res);
    }

}
