package com.kataer.mall.portal.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value = "用户登录参数")
@Data
public class UserInfo {
    @ApiModelProperty(value = "id")
    private Long id;
    @ApiModelProperty(value = "用户名", required = true)
    private String name;
    @ApiModelProperty(value = "密码", required = true)
    private String password;
    private Integer age;
    private String token;
}
