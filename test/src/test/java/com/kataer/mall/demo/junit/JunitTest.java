package com.kataer.mall.demo.junit;

import com.kataer.mall.demo.DemoApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@Slf4j
@ActiveProfiles("dev")
@SpringBootTest(classes = {DemoApplication.class})
public class JunitTest {

    @Test
    public void test() {
        Assertions.assertEquals(2, add(1, 1));
    }

    private int add(int a, int b) {
        return a + b;
    }
}
