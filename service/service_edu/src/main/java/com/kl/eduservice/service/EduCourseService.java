package com.kl.eduservice.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kl.eduservice.entity.EduCourse;
import com.kl.eduservice.entity.vo.CourseInfoVo;
import com.kl.eduservice.entity.vo.CoursePublishVo;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author 可乐
 * @since 2021-02-16
 */
@SuppressWarnings("all")
public interface EduCourseService extends IService<EduCourse> {

    /**
     * 添加课程信息
     * @param courseInfoVo
     */
    public String saveCourseInfo(CourseInfoVo courseInfoVo);

    /**
     * 根据课程id查询课程基本信息
     * @param courseId
     * @return
     */
    CourseInfoVo getCourseInfo(String courseId);

    /**
     * 修改课程信息
     * @param courseInfoVo
     */
    void updateCourseInfo(CourseInfoVo courseInfoVo);

    /**
     * 根据课程id查询整个即将发布课程的信息，用来确认
     * @param id
     * @return
     */
    CoursePublishVo publishCourseInfo(String id);
}
