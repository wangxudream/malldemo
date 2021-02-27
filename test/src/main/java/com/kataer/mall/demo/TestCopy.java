package com.kataer.mall.demo;

import cn.hutool.core.bean.BeanUtil;
import com.alibaba.fastjson.JSON;

public class TestCopy {
    public static void main(String[] args) {
//        User user1 = new User();
//        User user2 = new User();
//        user1.setName("user1");
//        user1.setAge(18);
//        user1.setGender("man");
//        System.out.println(user1);
//        System.out.println(user2);
//        System.out.println("before copy >>>>>>>>>>");
//        BeanUtil.copyProperties(user2, user1);
//        System.out.println(user1);
//        System.out.println(user2);
//        User user = JSON.parseObject(null, User.class);
//        System.out.println(user);
        String s = JSON.toJSONString(null);
        System.out.println(s);
    }

    private static class User {
        private String name;
        private Integer age;
        private String gender;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", gender='" + gender + '\'' +
                    '}';
        }
    }
}
