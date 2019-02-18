package com.codingapi.jta.example.service;


import com.codingapi.jta.example.dao.DemoDao;
import com.codingapi.jta.example.domain.Demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;

@Component
public class DemoService {

    @Autowired
    private PlatformTransactionManager platformTransactionManager;

    @Autowired
    private DemoDao demoDao;


    @Transactional
    public void save(){
        System.out.println(platformTransactionManager);
        Demo demo = new Demo();
        demo.setName("name");
        int res = demoDao.save(demo);
        System.out.println(res);
    }


}
