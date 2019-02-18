package com.codingapi.jta.example;

import com.codingapi.jta.example.service.DemoService;
import com.codingapi.txlcn.jta.JtaAutoConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import javax.annotation.PostConstruct;

@SpringBootApplication
@Import(JtaAutoConfiguration.class)
public class JtaExampleApplication  {

    public static void main(String[] args) {
        SpringApplication.run(JtaExampleApplication.class,args);
    }


    @Autowired
    private DemoService demoService;

    @PostConstruct
    public void start(){
        demoService.save();
    }
}
