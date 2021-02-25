package com.kl.eduservice.controller;

import com.kl.commonutils.Result;
import com.kl.eduservice.entity.EduVideo;
import com.kl.eduservice.service.EduVideoService;
import io.swagger.annotations.Api;
import org.apache.poi.ddf.EscherDump;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 课程课程小节视频管理 前端控制器
 * </p>
 *
 * @author 可乐
 * @since 2021-02-16
 */
@SuppressWarnings("all")
@Api(description = "课程课程小节视频管理")
@RestController
@CrossOrigin
@RequestMapping("/eduservice/video")
public class EduVideoController {

    @Autowired
    private EduVideoService eduVideoService;

    /**
     * 添加章节中的小结
     *
     * @param eduVideo
     * @return
     */
    @PostMapping("addVideo")
    public Result addVideo(@RequestBody EduVideo eduVideo) {
        eduVideoService.save(eduVideo);
        return Result.success().message("添加成功");
    }

    /**
     * 根据id删除小节以及视频
     *
     * @param id
     * @return
     */
    @DeleteMapping("{id}")
    public Result deleteVideo(@PathVariable String id) {
        eduVideoService.removeById(id);
        return Result.success().message("删除成功");
    }

}

















