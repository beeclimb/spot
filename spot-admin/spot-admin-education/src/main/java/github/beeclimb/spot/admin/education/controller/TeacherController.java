package github.beeclimb.spot.admin.education.controller;


import github.beeclimb.spot.admin.education.entity.Teacher;
import github.beeclimb.spot.admin.education.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.assertj.core.util.Lists.list;

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

    @GetMapping("queryAllTeachers")
    public List<Teacher> queryAllTeachers() {
        return teacherService.list();
    }

    @DeleteMapping("{id}")
    public boolean deleteTeacherById(@PathVariable String id) {
        return teacherService.removeById(id);
    }

}

