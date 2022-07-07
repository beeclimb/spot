package github.beeclimb.spot.admin.education.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import github.beeclimb.spot.admin.education.entity.Course;
import github.beeclimb.spot.admin.education.vo.CoursePublishVo;

/**
 * <p>
 * 课程 Mapper 接口
 * </p>
 *
 * @author baomidou
 * @since 2022-07-03
 */
public interface CourseMapper extends BaseMapper<Course> {

    CoursePublishVo selectCoursePublishInfo(String courseId);

}
