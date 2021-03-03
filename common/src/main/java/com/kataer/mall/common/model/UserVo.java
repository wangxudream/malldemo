package com.kataer.mall.common.model;

import lombok.Data;

@Data
public class UserVo {
    private Long id;
    private String name;
    private Integer age;
    private String token;
}
