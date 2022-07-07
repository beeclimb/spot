package github.beeclimb.spot.admin.education.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import github.beeclimb.spot.admin.education.entity.Course;
import github.beeclimb.spot.admin.education.entity.CourseDescription;
import github.beeclimb.spot.admin.education.mapper.CourseMapper;
import github.beeclimb.spot.admin.education.service.CourseDescriptionService;
import github.beeclimb.spot.admin.education.service.CourseService;
import github.beeclimb.spot.admin.education.vo.CourseInfoVo;
import github.beeclimb.spot.admin.education.vo.CoursePublishVo;
import github.beeclimb.spot.common.util.api.ResponseCodeEnum;
import github.beeclimb.spot.common.util.exception.ApiException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 课程 服务实现类
 * </p>
 *
 * @author baomidou
 * @since 2022-07-03
 */
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements CourseService {

    @Autowired
    private CourseDescriptionService courseDescriptionService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String saveCourseInfo(CourseInfoVo courseInfoVo) {
        Course course = new Course();
        BeanUtils.copyProperties(courseInfoVo, course);
        int success1 = baseMapper.insert(course);
        if (success1 <= 0) {
            throw new ApiException(ResponseCodeEnum.FAILED);
        }
        String courseId = course.getId();

        CourseDescription courseDescription = new CourseDescription();
        courseDescription.setDescription(courseInfoVo.getDescription());
        courseDescription.setId(courseId);
        boolean success2 = courseDescriptionService.save(courseDescription);
        if (!success2) {
            throw new ApiException(ResponseCodeEnum.FAILED);
        }

        return courseId;
    }

    @Override
    public CourseInfoVo getCourseInfoById(String courseId) {
        Course course = baseMapper.selectById(courseId);
        CourseInfoVo courseInfoVo = new CourseInfoVo();
        BeanUtils.copyProperties(course, courseInfoVo);

        CourseDescription courseDescription = courseDescriptionService.getById(courseId);
        courseInfoVo.setDescription(courseDescription.getDescription());

        return courseInfoVo;
    }

    @Override
    public void updateCourseInfo(CourseInfoVo courseInfoVo) {
        Course course = new Course();
        BeanUtils.copyProperties(courseInfoVo, course);
        baseMapper.updateById(course);

        CourseDescription courseDescription = new CourseDescription();
        courseDescription.setId(courseInfoVo.getId());
        courseDescription.setDescription(courseInfoVo.getDescription());
        courseDescriptionService.updateById(courseDescription);

    }

    @Override
    public CoursePublishVo getCoursePublishInfo(String courseId) {
        return baseMapper.selectCoursePublishInfo(courseId);
    }

    @Override
    public void putPublishCourse(String courseId) {
        Course course = new Course();
        course.setId(courseId);
        course.setStatus("Normal");
        baseMapper.updateById(course);

    }

}
