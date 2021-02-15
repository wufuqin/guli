package com.kl.oss.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * OSS service层接口
 */
@SuppressWarnings("all")
public interface OssService {

    /**
     * 上传头像的方法
     * @param file
     * @return
     */
    String uploadFileAvatar(MultipartFile file);
}
