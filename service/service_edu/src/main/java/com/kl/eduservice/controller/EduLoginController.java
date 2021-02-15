package com.kl.eduservice.controller;

import com.kl.commonutils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * 登录控制器
 */
@SuppressWarnings("all")
@Api(description = "用户登录")
@RestController
@RequestMapping("/eduservice/user")
@CrossOrigin
public class EduLoginController {

    /**
     * 登录
     *
     * @return
     */
    @ApiOperation(value = "登录方法")
    @PostMapping("login")
    public Result login() {
        return Result.success().message("登录成功").data("data", "token");
    }

    /**
     * 查询用户信息
     *
     * @return
     */
    @ApiOperation(value = "查询用户信息")
    @GetMapping("info")
    public Result info() {
        return Result.success().data("roles", "[admin]").data("name", "admin").data("avatar", "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
    }

}













