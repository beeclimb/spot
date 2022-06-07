package github.beeclimb.spot.admin.education.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import github.beeclimb.spot.admin.education.entity.Teacher;
import github.beeclimb.spot.admin.education.service.TeacherService;
import github.beeclimb.spot.admin.education.vo.TeacherVo;
import github.beeclimb.spot.common.util.api.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author baomidou
 * @since 2022-06-06
 */
@RestController
@RequestMapping("/education/teacher")
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    @GetMapping("/queryAllTeachers")
    public Response<List<Teacher>> queryAllTeachers() {
        return Response.success(teacherService.list());
    }

    @DeleteMapping("{id}")
    public Response deleteTeacherById(@PathVariable String id) {
        return teacherService.removeById(id) ? Response.success() : Response.fail();
    }

    @GetMapping("/pagination/{current}/{size}")
    public Response<Map<String, Object>> paginationQueryTeachers(@PathVariable long current, @PathVariable long size) {
        Page<Teacher> teacherPage = new Page<>(current, size);
        teacherService.page(teacherPage);
        Map<String, Object> dataMap = new HashMap<>(2);
        dataMap.put("total", teacherPage.getTotal());
        dataMap.put("records", teacherPage.getRecords());
        return Response.success(dataMap);
    }

    @PostMapping("/conditionalPagination/{current}/{size}")
    public Response conditionalPaginationQueryTeachers(@PathVariable long current, @PathVariable long size,
                                                       @RequestBody(required = false) TeacherVo teacherVo) {
        Page<Teacher> teacherPage = new Page<>(current, size);
        QueryWrapper<Teacher> teacherWrapper = new QueryWrapper<>();
        if (!ObjectUtils.isEmpty(teacherVo.getName())) {
            teacherWrapper.like("name", teacherVo.getName());
        }
        if (!ObjectUtils.isEmpty(teacherVo.getLevel())) {
            teacherWrapper.eq("level", teacherVo.getLevel());
        }
        if (!ObjectUtils.isEmpty(teacherVo.getStartTime())) {
            teacherWrapper.ge("gmt_create", teacherVo.getStartTime());
        }
        if (!ObjectUtils.isEmpty(teacherVo.getEndTime())) {
            teacherWrapper.le("gmt_modified", teacherVo.getEndTime());
        }

        teacherService.page(teacherPage, teacherWrapper);
        Map<String, Object> dataMap = new HashMap<>(2);
        dataMap.put("total", teacherPage.getTotal());
        dataMap.put("records", teacherPage.getRecords());
        return Response.success(dataMap);
    }

    @PostMapping("/addTeacher")
    public Response addTeacher(@RequestBody Teacher teacher) {
        return teacherService.save(teacher) ? Response.success(teacher) : Response.fail();
    }

    @GetMapping("/queryTeacherById/{id}")
    public Response<Teacher> queryTeacherById(@PathVariable String id) {
        return Response.success(teacherService.getById(id));
    }

    @PostMapping("/updateTeacherById")
    public Response updateTeacherById(@RequestBody Teacher teacher) {
        return teacherService.updateById(teacher) ? Response.success() : Response.fail();
    }

}
