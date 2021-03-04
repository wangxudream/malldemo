package com.kataer.mall.demo.condition;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConditionBean {

    //传入
    @Conditional(WindowsCondition.class)
    @Bean(name = "bill")
    public Person person1() {
        Person person = new Person();
        person.setName("bill");
        person.setAge(80);
        return person;
    }

    @Conditional(LinuxCondition.class)
    @Bean(name = "linus")
    public Person person2() {
        Person person = new Person();
        person.setName("linus");
        person.setAge(48);
        return person;
    }


//    @Bean
//    public Parent parent() {
//        return new Parent();
//    }

    @ConditionalOnBean(name = "parent")
    @Bean
    public Child child(Parent parent) {
        Child child = new Child();
        child.setParent(parent);
        return child;
    }

    @ConditionalOnClass(value = {Parent.class})
    @Bean("child2")
    public Child child2() {
        Child child = new Child();
        return child;
    }
}
