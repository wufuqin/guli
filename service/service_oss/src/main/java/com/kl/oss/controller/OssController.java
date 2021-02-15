package com.kl.oss.controller;

import com.kl.commonutils.Result;
import com.kl.oss.service.OssService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * OSS web控制器
 */
@SuppressWarnings("all")
@Api(description="OSS-Web控制器")
@RestController
@RequestMapping("/eduoss/fileoss")
@CrossOrigin
public class OssController {

    @Autowired
    private OssService ossService;

    /**
     * 上传头像的方法
     * @param file
     * @return
     */
    @ApiOperation(value = "上传头像的方法")
    @PostMapping
    public Result uploadOssFile(
            @ApiParam(name = "file", value = "上传的文件", required = true)
            @PathVariable MultipartFile file) {
        // 获取上传文件  MultipartFile
        String url = ossService.uploadFileAvatar(file);
        // 返回上传到oss的路径
        return Result.success().message("上传成功").data("url", url);
    }

}


















