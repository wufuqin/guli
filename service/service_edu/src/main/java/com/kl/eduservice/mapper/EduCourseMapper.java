package com.kl.eduservice.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kl.eduservice.entity.EduCourse;
import com.kl.eduservice.entity.vo.CoursePublishVo;

/**
 * <p>
 * 课程 Mapper 接口
 * </p>
 *
 * @author 可乐
 * @since 2021-02-16
 */
@SuppressWarnings("all")
public interface EduCourseMapper extends BaseMapper<EduCourse> {

    /**
     * 根据课程id查询整个即将发布课程的信息，用来确认
     * @param id
     * @return
     */
    CoursePublishVo getPublishCourseInfo(String id);
}
