package com.kl.eduservice.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kl.eduservice.entity.EduChapter;

import java.util.List;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author 可乐
 * @since 2021-02-16
 */
@SuppressWarnings("all")
public interface EduChapterService extends IService<EduChapter> {

    /**
     * 根据课程id查询
     * @param courseId
     * @return
     */
    List getChapterVideoByCourseId(String courseId);

    /**
     * 根据id删除章节
     * @param chapterId
     * @return
     */
    boolean deleteChapterById(String chapterId);
}
