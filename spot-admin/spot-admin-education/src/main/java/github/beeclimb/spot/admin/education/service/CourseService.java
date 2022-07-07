package github.beeclimb.spot.admin.education.service;

import com.baomidou.mybatisplus.extension.service.IService;
import github.beeclimb.spot.admin.education.entity.Course;
import github.beeclimb.spot.admin.education.vo.CourseInfoVo;
import github.beeclimb.spot.admin.education.vo.CoursePublishVo;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author baomidou
 * @since 2022-07-03
 */
public interface CourseService extends IService<Course> {

    String saveCourseInfo(CourseInfoVo courseInfoVo);

    CourseInfoVo getCourseInfoById(String courseId);

    void updateCourseInfo(CourseInfoVo courseInfoVo);

    CoursePublishVo getCoursePublishInfo(String courseId);

    void putPublishCourse(String courseId);
}
