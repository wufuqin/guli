package com.kl.eduservice.entity.subject;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 一级课程分类对应实体类
 * @author : 可乐
 * @date : 2021/2/15 19:23
 */
@SuppressWarnings("all")
@Data
public class OneSubject {

    private String id;    // 课程id
    private String title; // 课程名称

    //一个一级分类有多个二级分类
    private List<TwoSubject> children = new ArrayList<>();
}
