package com.kl.eduservice.controller;

import com.kl.eduservice.entity.EduTeacher;
import com.kl.eduservice.service.EduTeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author 可乐
 * @since 2021-01-26
 */
@SuppressWarnings("all")
@Api(description="讲师管理")
@RestController
@RequestMapping("/eduservice/teacher")
public class EduTeacherController {
    @Autowired
    private EduTeacherService eduTeacherService;

    /**
     * 查询所有教师
     * @return
     */
    @ApiOperation(value = "所有讲师列表")
    @GetMapping("findAll")
    public List<EduTeacher> findAllTeacher(){
        List<EduTeacher> list = eduTeacherService.list(null);
        return list;
    }

    /**
     * 根据id删除教师 逻辑删除
     * @param id
     * @return
     */
    @ApiOperation(value = "根据ID逻辑删除讲师")
    @DeleteMapping("{id}")
    public boolean removeTeacherById(@ApiParam(name = "id", value = "讲师ID", required = true) @PathVariable String id){
        return eduTeacherService.removeById(id);
    }



}






















