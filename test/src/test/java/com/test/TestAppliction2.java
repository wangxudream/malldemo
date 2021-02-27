package com.test;

import com.kataer.mall.demo.DemoApplication;
import com.kataer.mall.demo.config.ConfigA;
import com.kataer.mall.demo.config.ConfigB;
import com.kataer.mall.demo.config.SpringUtils;
import com.kataer.mall.demo.config.SpringUtils2;
import com.kataer.mall.demo.service.AspectService;
import com.kataer.mall.demo.service.AsyncService;
import com.kataer.mall.mbg.config.ConfigC;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@Slf4j
@ActiveProfiles("dev")
@SpringBootTest(classes = {DemoApplication.class})
public class TestAppliction2 {

    @Autowired
    private ConfigB configB;

    @Autowired
    private ConfigA configA;

    @Autowired
    private ConfigC configC;

    @Autowired
    private AsyncService asyncService;

    @Autowired
    private AspectService aspectService;

    @Test
    public void testImport() {
        configA.printName();
        configB.printName();
        configC.printName();
    }

    @Test
    public void testApplicationContext() {
        ApplicationContext applicationContext = SpringUtils.getApplicationContext();
        ConfigurableListableBeanFactory configurableListableBeanFactory = SpringUtils2.getConfigurableListableBeanFactory();
        System.out.println("applicationContext:" + applicationContext);
        System.out.println("configurableListableBeanFactory" + configurableListableBeanFactory);
        ConfigB.InnerClass innerClass1 = (ConfigB.InnerClass) applicationContext.getBean("bInnerClass");
        innerClass1.sayName();
        ConfigB.InnerClass innerClass2 = (ConfigB.InnerClass) configurableListableBeanFactory.getBean("bInnerClass");
        innerClass2.sayName();
    }

    @Test
    public void testAsync() {
        System.out.println("开始执行>>>>>>>>>>" + Thread.currentThread().getName());
        asyncService.testNormalMethod();
        asyncService.testStaticMethod();
        System.out.println("结束执行>>>>>>>>>>" + Thread.currentThread().getName());
    }

    @Test
    public void testParamCheck() {
        aspectService.testParamCheck("");
    }

}
