package github.beeclimb.spot.admin.education.controller;


import github.beeclimb.spot.admin.education.service.CourseService;
import github.beeclimb.spot.admin.education.vo.CourseInfoVo;
import github.beeclimb.spot.common.util.api.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 课程 前端控制器
 * </p>
 *
 * @author jun.ma
 * @since 2022-07-03
 */
@RestController
@RequestMapping("/education/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping("/addCourseInfo")
    public Response<Map<String, String>> addCourseInfo(@RequestBody CourseInfoVo courseInfoVo) {
        String courseId = courseService.saveCourseInfo(courseInfoVo);
        Map<String, String> data = new HashMap<>(1);
        data.put("courseId", courseId);
        return Response.success(data);
    }

}

