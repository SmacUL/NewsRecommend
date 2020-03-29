package com.smacul.demo.Experiment;


import org.apache.tomcat.jni.Poll;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 实验性功能
 */
@RestController
@RequestMapping("/exper")
public class ExperimentController {

    @RequestMapping("/a")
    public void experA() {
        PoolTest instance = PoolTest.getPollTest();
        instance.printA();
        instance.setA(2, 234);
        instance.printA();
    }

    @RequestMapping("/b")
    public void experB() {
        PoolTest instance = PoolTest.getPollTest();
        instance.printA();
    }

}
