package com.kl.eduservice.controller;

import com.kl.commonutils.Result;
import com.kl.eduservice.entity.EduCourse;
import com.kl.eduservice.entity.vo.CourseInfoVo;
import com.kl.eduservice.entity.vo.CoursePublishVo;
import com.kl.eduservice.service.EduCourseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 课程 前端控制器
 * </p>
 *
 * @author 可乐
 * @since 2021-02-16
 */
@SuppressWarnings("all")
@Api(description = "课程管理")
@RestController
@CrossOrigin
@RequestMapping("/eduservice/course")
public class EduCourseController {

    @Autowired
    private EduCourseService eduCourseService;

    /**
     * 添加课程信息
     *
     * @param courseInfoVo
     * @return
     */
    @PostMapping("addCourseInfo")
    public Result addCourseInfo(
            @ApiParam(name = "courseInfoVo", value = "课程vo对象", required = true)
            @RequestBody CourseInfoVo courseInfoVo) {
        //返回添加之后课程id，为了后面添加大纲使用
        String id = eduCourseService.saveCourseInfo(courseInfoVo);
        return Result.success().data("courseId", id);
    }

    /**
     * 根据课程id查询课程基本信息
     *
     * @return
     */
    @GetMapping("getCourseInfo/{courseId}")
    public Result getCourseInfo(
            @ApiParam(name = "courseId", value = "课程id", required = true)
            @PathVariable String courseId) {
        CourseInfoVo courseInfoVo = eduCourseService.getCourseInfo(courseId);
        return Result.success().message("查询成功").data("courseInfoVo", courseInfoVo);
    }

    /**
     * 修改课程信息
     *
     * @param courseInfoVo
     * @return
     */
    @PostMapping("updateCourseInfo")
    public Result updateCourseInfo(
            @ApiParam(name = "courseInfoVo", value = "课程vo对象", required = true)
            @RequestBody CourseInfoVo courseInfoVo) {
        eduCourseService.updateCourseInfo(courseInfoVo);
        return Result.success().message("修改成功");
    }

    /**
     * 根据课程id查询整个即将发布课程的信息，用来确认
     * @param id
     * @return
     */
    @GetMapping("getPublishCourseInfo/{id}")
    public Result getPublishCourseInfo(@PathVariable String id){
        CoursePublishVo coursePublishVo = eduCourseService.publishCourseInfo(id);
        return Result.success().message("查询成功").data("publishCourse",coursePublishVo);
    }

    /**
     * 根据课程id修改课程的status为Normal，为已经发布课程
     * @param id 课程id
     * @return
     */
    @PostMapping("publishCourse/{id}")
    public Result publishCourse(@PathVariable String id){
        EduCourse eduCourse = new EduCourse();
        eduCourse.setId(id);
        eduCourse.setStatus("Normal");
        eduCourseService.updateById(eduCourse);
        return Result.success().message("发布成功");
    }


}


















