package com.kataer.mall.demo;

import com.kataer.mall.demo.primary.Pet;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@Slf4j
@ActiveProfiles("dev")
@SpringBootTest(classes = {DemoApplication.class})
public class TestApplication3 {

   @Resource(name = "cat")
    private Pet pet;

    @Test
    public void testPrimary() {
        pet.sayHello();
    }
}
