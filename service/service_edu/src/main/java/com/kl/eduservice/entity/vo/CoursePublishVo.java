package com.kl.eduservice.entity.vo;

import lombok.Data;

/**
 * 发布课程时，确认课程信息vo类
 * @author : 可乐
 * @date : 2021/2/24 22:47
 */
@SuppressWarnings("all")
@Data
public class CoursePublishVo {

    private String id;                 // 课程id
    private String title;              // 课程标题
    private String cover;              // 封面
    private Integer lessonNum;         // 课时
    private String subjectLevelOne;    // 一级标题
    private String subjectLevelTwo;    // 二级标题
    private String teacherName;        // 讲师
    private String price;              // 只用于显示
}
