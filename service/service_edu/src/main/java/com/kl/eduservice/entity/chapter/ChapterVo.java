package com.kl.eduservice.entity.chapter;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 表示视频章节的vo类
 * @author : 可乐
 * @date : 2021/2/19 19:54
 */
@SuppressWarnings("all")
@Data
public class ChapterVo {

    private String id;

    private String title;

    //表示小节
    private List<VideoVo> children = new ArrayList<>();
}
