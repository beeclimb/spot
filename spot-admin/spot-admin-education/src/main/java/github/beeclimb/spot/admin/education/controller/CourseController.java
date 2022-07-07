package github.beeclimb.spot.admin.education.controller;


import github.beeclimb.spot.admin.education.service.CourseService;
import github.beeclimb.spot.admin.education.vo.CourseInfoVo;
import github.beeclimb.spot.admin.education.vo.CoursePublishVo;
import github.beeclimb.spot.common.util.api.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/getCourseInfo/{courseId}")
    public Response<Map<String, CourseInfoVo>> getCourseInfo(@PathVariable String courseId) {
        CourseInfoVo courseInfoVo = courseService.getCourseInfoById(courseId);
        Map<String, CourseInfoVo> data = new HashMap<>(1);
        data.put("course", courseInfoVo);
        return Response.success(data);
    }

    @PostMapping("/updateCourseInfo")
    public Response updateCourseInfo(@RequestBody CourseInfoVo courseInfoVo) {
        courseService.updateCourseInfo(courseInfoVo);
        return Response.success();
    }

    @GetMapping("/getCoursePublishInfoById/{courseId}")
    public Response<Map<String, CoursePublishVo>> getCoursePublishInfoById(@PathVariable String courseId) {
        CoursePublishVo coursePublishVo = courseService.getCoursePublishInfo(courseId);
        Map<String, CoursePublishVo> data = new HashMap<>(1);
        data.put("coursePublishVo", coursePublishVo);
        return Response.success(data);
    }

    @PutMapping("/publishCourseById/{courseId}")
    public Response publishCourseById(@PathVariable String courseId) {
        courseService.putPublishCourse(courseId);
        return Response.success();
    }

}

