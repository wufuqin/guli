package com.kl.eduservice.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kl.commonutils.Result;
import com.kl.eduservice.entity.EduTeacher;
import com.kl.eduservice.entity.vo.TeacherQuery;
import com.kl.eduservice.service.EduTeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author 可乐
 * @since 2021-01-26
 */
@SuppressWarnings("all")
@Api(description="讲师管理")
@RestController
@RequestMapping("/eduservice/teacher")
@CrossOrigin
public class EduTeacherController {

    @Autowired
    private EduTeacherService eduTeacherService;

    /**
     * 查询所有教师
     * @return
     */
    @ApiOperation(value = "所有讲师列表")
    @GetMapping("findAll")
    public Result findAllTeacher(){
        List<EduTeacher> list = eduTeacherService.list(null);
        return Result.success().message("查询成功").data("teachers",list);
    }

    /**
     * 根据id删除教师 逻辑删除
     * @param id
     * @return
     */
    @ApiOperation(value = "根据ID逻辑删除讲师")
    @DeleteMapping("{id}")
    public Result removeTeacherById(
            @ApiParam(name = "id", value = "讲师ID", required = true)
            @PathVariable String id){
        return eduTeacherService.removeById(id) ? Result.success().message("删除成功") : Result.error().message("删除失败");
    }

    /**
     * 分页查询讲师数据
     * @param current   当前页
     * @param limit     每页记录条数
     * @return
     */
    @ApiOperation(value = "分页查询讲师数据")
    @GetMapping("pageListTeachers/{current}/{limit}")
    public Result pageListTeachers(
            @ApiParam(name = "current", value = "当前页码", required = true)
            @PathVariable long current,
            @ApiParam(name = "limit", value = "每页记录数", required = true)
            @PathVariable long limit){

        // 创建分页对象
        Page<EduTeacher> teacherPage = new Page<EduTeacher>(current, limit);
        // 查询分页数据
        eduTeacherService.page(teacherPage, null);
        // 得到分页数据对象
        List<EduTeacher> records = teacherPage.getRecords();
        // 得到总记录数
        long total = teacherPage.getTotal();
        return  Result.success().message("查询成功").data("total", total).data("records", records);
    }

    /**
     * 条件查询讲师分页数据
     * @param current           当前页
     * @param limit             每页记录数
     * @param teacherQuery      查询条件vo对象
     * @return
     */
    @ApiOperation(value = "条件查询讲师分页数据")
    @PostMapping("pageTeacherCondition/{current}/{limit}")
    public Result pageTeacherCondition(
            @ApiParam(name = "current", value = "当前页码", required = true)
            @PathVariable long current,
            @ApiParam(name = "limit", value = "每页记录数", required = true)
            @PathVariable long limit,
            @RequestBody(required = false) TeacherQuery teacherQuery) {
        //创建page对象
        Page<EduTeacher> pageTeacher = new Page<>(current,limit);
        //构建条件
        QueryWrapper<EduTeacher> wrapper = new QueryWrapper<>();
        // 多条件组合查询
        String name = teacherQuery.getName();
        Integer level = teacherQuery.getLevel();
        String begin = teacherQuery.getBegin();
        String end = teacherQuery.getEnd();
        //判断条件值是否为空，如果不为空拼接条件
        if(!StringUtils.isEmpty(name)) {
            wrapper.like("name",name);
        }
        if(!StringUtils.isEmpty(level)) {
            wrapper.eq("level",level);
        }
        if(!StringUtils.isEmpty(begin)) {
            wrapper.ge("gmt_create",begin);
        }
        if(!StringUtils.isEmpty(end)) {
            wrapper.le("gmt_modified",end);
        }

        //调用方法实现条件查询分页
        eduTeacherService.page(pageTeacher,wrapper);

        long total = pageTeacher.getTotal();//总记录数
        List<EduTeacher> records = pageTeacher.getRecords(); //数据list集合
        return Result.success().message("查询成功").data("total",total).data("rows",records);
    }

    /**
     * 新增讲师
     * @param teacher
     * @return
     */
    @ApiOperation(value = "新增讲师")
    @PostMapping("addTeacher")
    public Result addTeacher(
            @ApiParam(name = "teacher", value = "讲师对象", required = true)
            @RequestBody EduTeacher teacher){
        return eduTeacherService.save(teacher) ? Result.success().message("添加成功") : Result.error().message("添加失败");
    }

    /**
     * 根据讲师id进行查询
     * @param id
     * @return
     */
    @ApiOperation(value = "根据讲师id进行查询")
    @GetMapping("getTeacherById/{id}")
    public Result getTeacherById(
            @ApiParam(name = "id", value = "讲师id", required = true)
            @PathVariable String id) {
        EduTeacher eduTeacher = eduTeacherService.getById(id);
        return Result.success().message("查询成功").data("teacher",eduTeacher);
    }

    /**
     * 根据id修改讲师信息
     * @param eduTeacher
     * @return
     */
    @ApiOperation(value = "根据id修改讲师信息")
    @PostMapping("updateTeacherById")
    public Result updateTeacherById(
            @ApiParam(name = "eduTeacher", value = "讲师对象", required = true)
            @RequestBody EduTeacher eduTeacher) {
        return eduTeacherService.updateById(eduTeacher) ? Result.success().message("修改成功") : Result.error().message("修改失败");
    }

}
