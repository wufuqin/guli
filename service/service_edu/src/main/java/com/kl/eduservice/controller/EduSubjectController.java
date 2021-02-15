package com.kl.eduservice.controller;

import com.kl.commonutils.Result;
import com.kl.eduservice.entity.subject.OneSubject;
import com.kl.eduservice.service.EduSubjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 * 课程科目 前端控制器
 * </p>
 *
 */
@SuppressWarnings("all")
@Api(description = "课程分类")
@RestController
@RequestMapping("/eduservice/subject")
@CrossOrigin
public class EduSubjectController {

    @Autowired
    private EduSubjectService subjectService;

    /**
     * 添加课程分类
     * 获取上传过来文件，把文件内容读取出来
     * @param file
     * @return
     */
    @ApiOperation(value = "添加课程分类")
    @PostMapping("addSubject")
    public Result addSubject(
            @ApiParam(name = "file", value = "上传的文件", required = true)
            MultipartFile file) {
        //上传过来excel文件
        subjectService.saveSubject(file,subjectService);
        return Result.success().message("添加成功");
    }

    /**
     * 课程分类列表（树形）
     * @return
     */
    @ApiOperation(value = "查询所有课程分类列表")
    @GetMapping("getAllSubject")
    public Result getAllSubject() {
        //list集合泛型是一级分类
        List<OneSubject> list = subjectService.getAllOneTwoSubject();
        return Result.success().message("查询成功").data("list",list);
    }

}

