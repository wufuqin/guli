package com.ks.eduservice.controller;

import com.ks.eduservice.entity.EduTeacher;
import com.ks.eduservice.service.EduTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

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
@RestController
@RequestMapping("/eduservice/teacher")
public class EduTeacherController {
    @Autowired
    private EduTeacherService eduTeacherService;

    /**
     * 查询所有教师
     * @return
     */
    @GetMapping("findAll")
    public List<EduTeacher> findAllTeacher(){
        List<EduTeacher> list = eduTeacherService.list(null);
        return list;
    }


}






















