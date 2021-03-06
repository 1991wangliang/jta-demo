package com.codingapi.jta.example.service;


import com.codingapi.jta.example.dao.DemoDao;
import com.codingapi.jta.example.domain.Demo;
import com.codingapi.jta.example.exception.MyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class DemoService {


    @Autowired
    private DemoDao demoDao;

    @Autowired
    private DemoService2 demoService2;

    @Transactional(rollbackFor = MyException.class)
    public void save() throws MyException{
        Demo demo = new Demo();
        demo.setName("name");
        int res = demoDao.save(demo);
        System.out.println(res);

        throw new MyException("my error.");
//        demoService2.test();
    }


}
