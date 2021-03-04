package com.kataer.mall.demo;

import com.kataer.mall.demo.condition.Child;
import com.kataer.mall.demo.condition.Person;
import com.kataer.mall.demo.config.ConfigA;
import com.kataer.mall.demo.config.ConfigB;
import com.kataer.mall.demo.config.SpringUtils2;
import com.kataer.mall.demo.service.AspectService;
import com.kataer.mall.demo.service.AsyncService;
import com.kataer.mall.demo.config.SpringUtils;
import com.kataer.mall.mbg.config.ConfigC;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

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

    //允许注入的对象为null
    @Autowired(required = false)
    private Child child;

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


    @Test
    public void testCondition() {
        //{bill=Person(name=bill, age=80), linus=Person(name=linus, age=48)}
        //{bill=Person(name=bill, age=80)}
        Map<String, Person> persons = SpringUtils.getApplicationContext().getBeansOfType(Person.class);
        System.out.println(persons);
    }

    @Test
    public void testConditionOnBean() {
        System.out.println("child:" + child);
        Object child2 = SpringUtils.getApplicationContext().getBean("child2");
        System.out.println("child2:" + child2);
    }

}
