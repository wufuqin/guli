package com.kl.eduservice.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kl.eduservice.entity.EduSubject;
import com.kl.eduservice.entity.subject.OneSubject;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 * 课程科目 服务类
 * </p>
 *
 * @author 可乐
 * @since 2020-02-29
 */
@SuppressWarnings("all")
public interface EduSubjectService extends IService<EduSubject> {

    /**
     * 添加课程分类
     *
     * @param file
     * @param subjectService
     */
    void saveSubject(MultipartFile file, EduSubjectService subjectService);

    /**
     * 课程分类列表
     * @return
     */
    List<OneSubject> getAllOneTwoSubject();
}
