package com.kl.commonutils;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * 统一返回结果
 * @Author: 可乐
 * @Date: 19:15 2021/1/28
 */
@SuppressWarnings("all")
@Data
public class Result {

    @ApiModelProperty(value = "是否成功")
    private Boolean success;

    @ApiModelProperty(value = "返回码")
    private Integer code;

    @ApiModelProperty(value = "返回消息")
    private String message;

    @ApiModelProperty(value = "返回数据")
    private Map<String, Object> data = new HashMap<String, Object>();

    /**
     * 使构造方法私有化，外界不能再实例化该类，只能调用类中的静态方法
     */
    private Result(){}

    /**
     * 操作成功
     * @return
     */
    public static Result success(){
        Result result = new Result();
        result.setSuccess(true);
        result.setCode(ResultCode.SUCCESS);
        result.setMessage("成功");
        return result;
    }

    /**
     * 操作失败
     * @return
     */
    public static Result error(){
        Result result = new Result();
        result.setSuccess(false);
        result.setCode(ResultCode.ERROR);
        result.setMessage("失败");
        return result;
    }

    public Result success(Boolean success){
        this.setSuccess(success);
        return this;
    }

    public Result message(String message){
        this.setMessage(message);
        return this;
    }

    public Result code(Integer code){
        this.setCode(code);
        return this;
    }

    /**
     * 键值对
     * @param key   键
     * @param value 值
     * @return
     */
    public Result data(String key, Object value){
        this.data.put(key, value);
        return this;
    }

    /**
     * 传入一个map集合
     * @param map
     * @return
     */
    public Result data(Map<String, Object> map){
        this.setData(map);
        return this;
    }

}
