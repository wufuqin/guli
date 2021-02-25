package com.kl.eduservice.controller;

import com.kl.commonutils.Result;
import com.kl.eduservice.entity.EduChapter;
import com.kl.eduservice.service.EduChapterService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 课程章节管理 前端控制器
 * </p>
 *
 * @author 可乐
 * @since 2021-02-16
 */
@SuppressWarnings("all")
@Api(description = "课程章节管理")
@RestController
@CrossOrigin
@RequestMapping("/eduservice/chapter")
public class EduChapterController {

    @Autowired
    private EduChapterService eduChapterService;

    /**
     * 根据课程id查询
     *
     * @param courseId
     * @return
     */
    @ApiOperation(value = "根据课程id查询")
    @GetMapping("getChapterVideo/{courseId}")
    public Result getChapterVideo(
            @ApiParam(name = "courseId", value = "课程ID", required = true)
            @PathVariable String courseId) {
        List list = eduChapterService.getChapterVideoByCourseId(courseId);
        return Result.success().message("查询成功").data("allChapterVideo", list);
    }

    /**
     * 添加章节
     * @return
     */
    @ApiOperation(value = "添加章节")
    @PostMapping("addChapter")
    public Result addChapter(
            @ApiParam(name = "eduChapter", value = "EduChapter对象", required = true)
            @RequestBody EduChapter eduChapter){
        eduChapterService.save(eduChapter);
        return Result.success().message("添加成功");
    }

    /**
     * 根据id查询章节数据
     * @param chapterId
     * @return
     */
    @ApiOperation(value = "根据id查询章节数据")
    @GetMapping("getChapterInfo/{chapterId}")
    public Result getChapterInfo(
            @ApiParam(name = "chapterId", value = "章节id", required = true)
            @PathVariable String chapterId){
        EduChapter eduChapter = eduChapterService.getById(chapterId);
        return Result.success().message("查询成功").data("eduChapter",eduChapter);
    }

    /**
     * 根据id修改章节数据
     * @param eduChapter
     * @return
     */
    @ApiOperation(value = "根据id修改章节数据")
    @PostMapping("updateChapter")
    public Result updateChapter(
            @ApiParam(name = "chapter", value = "EduChapter对象", required = true)
            @RequestBody EduChapter eduChapter){
        eduChapterService.updateById(eduChapter);
        return Result.success().message("修改成功");
    }

    /**
     * 根据id删除章节
     * @param chapterId
     * @return
     */
    @ApiOperation(value = "根据id删除章节")
    @DeleteMapping("{chapterId}")
    public Result deleteChapter(
            @ApiParam(name = "chapterId", value = "章节id", required = true)
            @PathVariable String chapterId){

        boolean flag = eduChapterService.deleteChapterById(chapterId);
        if (flag){
            return Result.success().message("删除成功");
        }else {
            return Result.error().message("存着小节，删除失败");
        }

    }

}







