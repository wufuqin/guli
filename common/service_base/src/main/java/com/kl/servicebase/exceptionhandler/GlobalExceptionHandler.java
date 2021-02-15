package com.kl.servicebase.exceptionhandler;

import com.kl.commonutils.Result;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 统一异常处理类
 * @Author: 可乐
 * @Date: 23:03 2021/1/28
 */
@SuppressWarnings("all")
@ControllerAdvice
public class GlobalExceptionHandler {

    //指定出现什么异常执行这个方法
    @ExceptionHandler(Exception.class)
    @ResponseBody       //为了返回数据
    public Result error(Exception e) {
        e.printStackTrace();
        return Result.error().message("执行了全局异常处理..");
    }

   /* //自定义异常
    @ExceptionHandler(GuliException.class)
    @ResponseBody //为了返回数据
    public Result error(GuliException e) {
        log.error(e.getMessage());
        e.printStackTrace();
        return Result.error().code(e.getCode()).message(e.getMsg());
    }*/

    /**
     * 当添加的用户名称重复时执行
     * @param DuplicateKeyException
     * @return
     */
    @ExceptionHandler(DuplicateKeyException.class)
    @ResponseBody
    public Result error(DuplicateKeyException duplicateKeyException) {
        duplicateKeyException.printStackTrace();
        return Result.error().message("该名称已经存在...");
    }

}
