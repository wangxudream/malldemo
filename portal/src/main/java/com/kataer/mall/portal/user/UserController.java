package com.kataer.mall.portal.user;

import com.alibaba.fastjson.JSON;
import com.kataer.mall.common.ResultBody;
import com.kataer.mall.common.model.UserVo;
import com.kataer.mall.common.util.JwtUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

@Api(tags = "用户API")
@Slf4j
@RequestMapping("/user")
@RestController
public class UserController {
    public static final String LOGIN_TOKEN_KEY = "X-PointsShop-Token";
    @Resource
    private JwtUtil jwtUtil;

    @ApiOperation(value = "用户登录接口")
    @PostMapping("/login")
    public ResultBody login(@RequestBody UserInfo userInfo, HttpServletResponse response) {
        log.info("登录成功");
        String jwt = jwtUtil.createJWT("login", JSON.toJSONString(userInfo));
        response.setHeader(LOGIN_TOKEN_KEY, jwt);
        return ResultBody.success();
    }
}
